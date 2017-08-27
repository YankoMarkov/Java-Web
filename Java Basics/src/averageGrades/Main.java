package averageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		List<Student> students = addStudents();
		students.stream()
				.filter(s -> s.getAverageGrades() >= 5)
				.sorted((a1, a2) -> {
					int compareByName = a1.getName().compareTo(a2.getName());
					
					if (compareByName == 0) {
						compareByName = Double.compare(a2.getAverageGrades(), a1.getAverageGrades());
					}
					return compareByName;
				})
				.forEach(s -> System.out.printf("%s -> %.2f%n", s.getName(), s.getAverageGrades()));
	}
	
	private static List<Student> addStudents() throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Student> students = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			String[] input = read.readLine().split("\\s+");
			students.add(new Student(input[0], studentGrades(input), averageGrade(studentGrades(input))));
		}
		return students;
	}
	
	private static double averageGrade(List<Double> doubles) {
		double sum = 0;
		double average = 0;
		
		for (int i = 0; i < doubles.size(); i++) {
			sum += doubles.get(i);
		}
		average = sum / doubles.size();
		return average;
	}
	
	
	private static List<Double> studentGrades(String[] input) {
		List<Double> grades = new ArrayList<>();
		
		for (int i = 1; i < input.length; i++) {
			grades.add(Double.valueOf(input[i]));
		}
		return grades;
	}
}
