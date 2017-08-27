import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringIn20Chars {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = read.readLine();
		StringBuilder result = new StringBuilder();
		
		if (input.length() < 20) {
			result.append(input);
			for (int i = input.length(); i < 20; i++) {
				result.append("*");
			}
		} else {
			for (int i = 0; i < 20; i++) {
				result.append(input.charAt(i));
			}
		}
		System.out.println(result);
	}
}
