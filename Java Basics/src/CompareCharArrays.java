import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareCharArrays {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] first = read.readLine().split(" ");
		String[] second = read.readLine().split(" ");
		StringBuilder firstOne = new StringBuilder();
		StringBuilder secondOne = new StringBuilder();
		for (String s : first) {
			firstOne.append(s);
		}
		for (String s : second) {
			secondOne.append(s);
		}
		
		if (firstOne.length() < secondOne.length()) {
			System.out.println(firstOne);
			System.out.println(secondOne);
		} else if (secondOne.length() < firstOne.length()) {
			System.out.println(secondOne);
			System.out.println(firstOne);
		} else {
			if (firstOne.toString().compareTo(secondOne.toString()) <= 0) {
				System.out.println(firstOne);
				System.out.println(secondOne);
			} else {
				System.out.println(secondOne);
				System.out.println(firstOne);
			}
		}
	}
}
