import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class AdvertisementMessage {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.valueOf(read.readLine());
		
		String[] phrases = new String[]{
				"Excellent product.",
				"Such a great product.",
				"I always use that product.",
				"Best product of its category.",
				"Exceptional product.",
				"I can’t live without this product."
		};
		
		String[] events = new String[]{
				"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
		};
		
		String[] cities = new String[]{
				"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
		};
		
		Random random = new Random();
		String result = "";
		
		for (int i = 0; i < input; i++) {
			result = phrases[random.nextInt(phrases.length)] + " " + events[random.nextInt(events.length)] + " " + cities[random.nextInt(cities.length)];
			System.out.println(result);
		}
	}
}
