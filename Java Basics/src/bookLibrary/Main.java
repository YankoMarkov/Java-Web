package bookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		List<Book> book = addToLibrary(read);
		Map<String, Double> authors = authorTotalPrice(book);
		authors.entrySet().stream()
				.sorted((a1, a2) -> {
					int sort = a2.getValue().compareTo(a1.getValue());
					if (sort == 0) {
						sort = a1.getKey().compareTo(a2.getKey());
					}
					return sort;
				})
				.forEach(res -> System.out.printf("%s -> %.2f%n", res.getKey(), res.getValue()));
	}
	
	private static Map<String, Double> authorTotalPrice(List<Book> books) {
		Map<String, Double> result = new HashMap<>();
		for (Book book : books) {
			if (!result.containsKey(book.getAuthor())) {
				result.put(book.getAuthor(), 0.0);
			}
			result.put(book.getAuthor(), result.get(book.getAuthor()) + book.getPrice());
		}
		return result;
	}
	
	private static Book readBook(BufferedReader reader) throws IOException, ParseException {
		String[] input = reader.readLine().split("\\s+");
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date date = df.parse(input[3]);
		
		Book book = new Book();
		book.setTitle(input[0]);
		book.setAuthor(input[1]);
		book.setPublisher(input[2]);
		book.setReleaseDate(date);
		book.setIsbnNumber(input[4]);
		book.setPrice(Double.valueOf(input[5]));
		
		return book;
	}
	
	private static List<Book> addToLibrary(BufferedReader reader) throws IOException, ParseException {
		int num = Integer.valueOf(reader.readLine());
		
		Library library = new Library();
		
		for (int i = 0; i < num; i++) {
			Book book = readBook(reader);
			library.getBooks().add(book);
		}
		return library.getBooks();
	}
}
