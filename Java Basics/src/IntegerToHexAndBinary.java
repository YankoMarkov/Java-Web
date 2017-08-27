import java.util.Scanner;

public class IntegerToHexAndBinary {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.valueOf(scan.nextLine());
		
		String hex = String.format("%X", input);
		System.out.println(hex);
		System.out.println(Integer.toBinaryString(input));
	}
}
