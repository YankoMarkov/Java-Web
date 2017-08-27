package averageGrades;

import java.util.List;

class Student {
	
	private String name;
	private List<Double> grades;
	private double averageGrades;
	
	public Student(String name, List<Double> grades, double averageGrades) {
		this.name = name;
		this.grades = grades;
		this.averageGrades = averageGrades;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Double> getGrades() {
		return grades;
	}
	
	public void setGrades(List<Double> grades) {
		this.grades = grades;
	}
	
	public double getAverageGrades() {
		return averageGrades;
	}
	
	public void setAverageGrades(double averageGrades) {
		this.averageGrades = averageGrades;
	}
}
