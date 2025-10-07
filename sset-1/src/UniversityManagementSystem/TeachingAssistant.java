package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class TeachingAssistant extends Student implements Researchable {
	private Professor supervisor;
	private List<String> assistedCourses;
	private double stipend;

	public TeachingAssistant(String name, int age, String major, Professor supervisor) {
		super(name, age, major); // Calling Student constructor
		this.supervisor = supervisor;
		this.assistedCourses = new ArrayList<>();
		this.stipend = 0.0;
	}

	@Override
	public String getRole() {
		return "Teaching Assistant";
	}

	// TA-specific course enrollment (overrides Student behavior)
	@Override
	public void enrollCourse(String course) {
		super.enrollCourse(course); // Still enroll as student
		// Additional TA-specific logic
		System.out.println(name + " is also assisting in " + course);
	}

	// Researchable interface implementation
	@Override
	public void conductResearch() {
		if (supervisor != null) {
			System.out.println(name + " is conducting research under Prof. " + supervisor.getName());
		} else {
			System.out.println(name + " is conducting independent research");
		}
	}

	@Override
	public void publishPaper(String title) {
		System.out.println("TA " + name + " published research paper: " + title);
	}

	// TA-specific methods
	public void conductLabSession(String course) {
		System.out.println(name + " is conducting lab session for " + course);
	}

	public void gradeAssignments(String course, int numberOfAssignments) {
		System.out.println(name + " graded " + numberOfAssignments + " assignments for " + course);
	}

	public Professor getSupervisor() {
		return supervisor;
	}

	public double getStipend() {
		return stipend;
	}

	public void setStipend(double stipend) {
		this.stipend = stipend;
	}

	@Override
	public String getDetails() {
		String baseDetails = super.getDetails(); // Get Student details
		return baseDetails + String.format(", Supervisor: %s, Stipend: $%.2f",
				supervisor != null ? supervisor.getName() : "None", stipend);
	}
}
