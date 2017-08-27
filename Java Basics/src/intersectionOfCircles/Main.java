package intersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Circle c1 = createCircle(read);
		Circle c2 = createCircle(read);
		
		int distance = calculateDistanceBetweenCenters(c1, c2);
		
		if (distance <= c1.getRadius() + c2.getRadius()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}
	
	private static Circle createCircle(BufferedReader reader) throws IOException {
		int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		Point point = new Point();
		point.setX(input[0]);
		point.setY(input[1]);
		
		Circle circle = new Circle();
		circle.setRadius(input[2]);
		circle.setCenter(point);
		
		return circle;
	}
	
	private static int calculateDistanceBetweenCenters(Circle c1, Circle c2) {
		int x = Math.abs(c1.getCenter().getX() - c2.getCenter().getX());
		int y = Math.abs(c1.getCenter().getY() - c2.getCenter().getY());
		
		int distance = (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return distance;
	}
}
