import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualSums {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] arrays = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		for (int i = 0; i < arrays.length; i++) {
			int leftSum = leftSumArray(arrays, i);
			int rightSum = rightSumArray(arrays, i);
			if (leftSum == rightSum) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("no");
	}
	
	private static int leftSumArray(int[] arr, int index) {
		int sum = 0;
		for (int i = index; i >= 0; i--) {
			if (i == 0) {
				sum += 0;
				break;
			} else {
				sum += arr[i - 1];
			}
		}
		return sum;
	}
	
	private static int rightSumArray(int[] arr, int index) {
		int sum = 0;
		for (int i = index; i <= arr.length; i++) {
			int nextIndex = (i + 1) % arr.length;
			if (arr.length == 1 || nextIndex == 0) {
				sum += 0;
				break;
			} else {
				sum += arr[nextIndex];
			}
		}
		return sum;
	}
}
