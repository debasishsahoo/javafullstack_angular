import java.util.List;

public class StudentStatistics {
	private long totalStudents;
	private int totalGrades;
	private int totalCities;
	private List<String> grades;
	private List<String> cities;
	private double averageMarks;

	public StudentStatistics(long totalStudents, int totalGrades, int totalCities, List<String> grades,
			List<String> cities, double averageMarks) {
		this.totalStudents = totalStudents;
		this.totalGrades = totalGrades;
		this.totalCities = totalCities;
		this.grades = grades;
		this.cities = cities;
		this.averageMarks = averageMarks;
	}

	public long getTotalStudents() {
		return totalStudents;
	}

	public int getTotalGrades() {
		return totalGrades;
	}

	public int getTotalCities() {
		return totalCities;
	}

	public List<String> getGrades() {
		return grades;
	}

	public List<String> getCities() {
		return cities;
	}

	public double getAverageMarks() {
		return averageMarks;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Total Students: ").append(totalStudents).append("\n");
		sb.append(" Total Grades: ").append(totalGrades).append("\n");
		sb.append(" Grades: ").append(String.join(", ", grades)).append("\n");
		sb.append(" Total Cities: ").append(totalCities).append("\n");
		sb.append(" Cities: ").append(String.join(", ", cities)).append("\n");
		sb.append(String.format("Average Marks: %.2f%n", averageMarks));
		return sb.toString();
	}

}
