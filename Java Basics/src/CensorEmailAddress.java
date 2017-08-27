import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CensorEmailAddress {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String email = read.readLine();
		String[] mails = email.split("@");
		String username = mails[0];
		String domain = mails[1];
		String input = read.readLine();
		
		StringBuilder replaces = new StringBuilder();
		for (int i = 0; i < username.length(); i++) {
			replaces.append("*");
		}
		replaces.append("@").append(domain);
		String replace = replaces.toString();
		input = input.replaceAll(email, replace);
		System.out.println(input);
	}
}
