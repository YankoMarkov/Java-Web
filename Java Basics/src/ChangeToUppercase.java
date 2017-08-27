import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeToUppercase {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(read.readLine());
		
		int startIndex = input.indexOf("<upcase>");
		int endIndex = input.indexOf("</upcase>");
		
		while (endIndex != -1) {
			String temp = input.substring(startIndex + 8, endIndex).toUpperCase();
			input = input.replace(startIndex, endIndex + 9, temp);
			startIndex = input.indexOf("<upcase>", startIndex + 1);
			endIndex = input.indexOf("</upcase>", startIndex + 1);
		}
		System.out.println(input);
	}
}
