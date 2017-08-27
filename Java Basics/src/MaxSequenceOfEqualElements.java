import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfEqualElements {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		int count = 1;
		int index = 0;
		int bestCount = 0;
		int bestIndex = 0;
		
		for (int i = 1; i < input.length; i++) {
			if (input[i] != input[i - 1]) {
				index = i;
				count = 1;
			} else {
				count++;
			}
			if (bestCount < count) {
				bestCount = count;
				bestIndex = index;
			}
		}
		for (int i = bestIndex; i < bestIndex + bestCount; i++) {
			System.out.printf("%d ", input[i]);
		}
	}
}
