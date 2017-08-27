import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MostFrequentNumber {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		
		int bestCount = 0;
		int mostFrequentNumber = 0;
		
		for (int i = 0; i < input.length; i++) {
			int count = 0;
			for (int j = i; j < input.length; j++) {
				if (input[j] == input[i]) {
					count++;
				}
			}
			if (bestCount < count) {
				bestCount = count;
				mostFrequentNumber = input[i];
			}
		}
		System.out.println(mostFrequentNumber);
	}
}
