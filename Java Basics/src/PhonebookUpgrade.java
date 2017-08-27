import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class PhonebookUpgrade {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> res = new TreeMap<>();
		String inputs = null;
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split("\\s+");
			String command = input[0];
			
			if (command.equals("A")) {
				String name = input[1];
				String phone = input[2];
				if (!res.containsKey(name)) {
					res.put(name, phone);
				}
				if (!res.get(name).equals(phone)) {
					res.replace(name, phone);
				}
			}
			if (command.equals("ListAll")) {
				for (Map.Entry<String, String> result : res.entrySet()) {
					System.out.printf("%s -> %s%n", result.getKey(), result.getValue());
				}
				break;
			}
		}
	}
}
