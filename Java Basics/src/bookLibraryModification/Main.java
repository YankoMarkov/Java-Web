package bookLibraryModification;

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
		Map<String, Date> authors = authorTotalPrice(book);
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date date = df.parse(read.readLine());
		
		authors.entrySet().stream()
				.filter(s -> s.getValue().after(date))
				.sorted((a1, a2) -> {
					int sort = a1.getValue().compareTo(a2.getValue());
					if (sort == 0) {
						sort = a1.getKey().compareTo(a2.getKey());
					}
					return sort;
				})
				.forEach(res -> System.out.printf("%s -> %s%n", res.getKey(),
						new SimpleDateFormat("dd.MM.yyyy").format(res.getValue())));
	}
	
	private static Map<String, Date> authorTotalPrice(List<Book> books) {
		Map<String, Date> result = new HashMap<>();
		for (Book book : books) {
			if (!result.containsKey(book.getTitle())) {
				result.put(book.getTitle(), new Date());
			}
			result.put(book.getTitle(), book.getReleaseDate());
		}
		return result;
	}
	
	private static Book readBook(BufferedReader reader) throws IOException, ParseException {
		String[] input = reader.readLine().split("\\s+");
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date date = df.parse(input[3]);
		int a = 0;
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
