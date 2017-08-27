import java.util.Scanner;

public class VowelOrDigit {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		char inputs = input.charAt(0);
		
		if (Character.isDigit(inputs)) {
			System.out.println("digit");
		} else if (inputs == 'a' || inputs == 'e' || inputs == 'i' || inputs == 'o' || inputs == 'u') {
			System.out.println("vowel");
		} else {
			System.out.println("other");
		}
	}
}
