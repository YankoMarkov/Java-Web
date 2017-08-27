import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCharacters {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String first = read.readLine();
		String second = read.readLine();
		String third = read.readLine();
		
		String[] result = new String[]{third, second, first};
		for (String s : result) {
			System.out.print(s);
		}
	}
}
