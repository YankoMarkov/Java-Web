import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> result = new HashMap<>();
		String inputs = null;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String command = input[0];
			String name = input[1];
			
			if (command.equals("A")) {
				String phone = input[2];
				if (!result.containsKey(name)) {
					result.put(name, phone);
				}
				if (!result.get(name).equals(phone)) {
					result.put(name, phone);
				}
			}
			if (command.equals("S")) {
				if (result.containsKey(name)) {
					System.out.printf("%s -> %s%n", name, result.get(name));
				} else {
					System.out.printf("Contact %s does not exist.%n", name);
				}
			}
		}
	}
}
