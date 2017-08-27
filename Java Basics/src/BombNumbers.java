import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> condition = Arrays.stream(read.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
		
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).equals(condition.get(0))) {
				int startIndex = 0;
				int endIndex = 0;
				
				if (i - condition.get(1) < 0) {
					startIndex = 0;
				} else {
					startIndex = i - condition.get(1);
				}
				if (i + condition.get(1) > input.size() - 1) {
					endIndex = input.size() - 1;
				} else {
					endIndex = i + condition.get(1);
				}
				input.subList(startIndex, endIndex + 1).clear();
				i = 0;
			}
		}
		int sum = 0;
		for (Integer integer : input) {
			sum += integer;
		}
		System.out.println(sum);
	}
}
