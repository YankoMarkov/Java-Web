import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UrlParser {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("://");
		String protocol = "";
		String server = "";
		String resource = "";
		
		if (input.length < 2 && !input[0].contains("/")) {
			server = input[0];
		} else if (input.length < 2 && input[0].contains("/")) {
			int index = input[0].indexOf("/");
			server = input[0].substring(0, index);
			resource = input[0].substring(index + 1, input[0].length());
		} else if (input.length == 2 && !input[1].contains("/")) {
			protocol = input[0];
			server = input[1];
		} else if (input.length >= 2){
			protocol = input[0];
			int index = input[1].indexOf("/");
			server = input[1].substring(0, index);
			resource = input[1].substring(index + 1, input[1].length());
		}
		System.out.printf("[protocol] = \"%s\"\n", protocol);
		System.out.printf("[server] = \"%s\"\n", server);
		System.out.printf("[resource] = \"%s\"\n", resource);
	}
}
