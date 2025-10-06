package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person implements CourseParticipant, Researchable {
	private String department;
	private List<String> coursesTaught;
	private String researchArea;
	private int yearsOfExperience;

	public Professor(String name, int age, String department, String researchArea) {
		super(name, age);
		this.department = department;
		this.researchArea = researchArea;
		this.coursesTaught = new ArrayList<>();
		this.yearsOfExperience = 0;
	}

	@Override
	public String getRole() {
		return "Professor";
	}

	@Override
	public void enrollCourse(String course) {
		// Professor version - teaching a course
		if (!coursesTaught.contains(course)) {
			coursesTaught.add(course);
			System.out.println("Prof. " + name + " will teach " + course);
		}
	}

	@Override
	public void dropCourse(String course) {
		if (coursesTaught.remove(course)) {
			System.out.println("Prof. " + name + " stopped teaching " + course);
		}
	}

	@Override
	public List<String> getCourses() {
		return new ArrayList<>(coursesTaught);
	}

	@Override
	public void conductResearch() {
		System.out.println("Prof. " + name + " is conducting research in " + researchArea);
	}

	@Override
	public void publishPaper(String title) {
		System.out.println("Prof. " + name + " published: " + title);
	}

	public void gradeStudent(Student student, String course, double grade) {
		System.out.println("Grading " + student.getName() + " in " + course + ": " + grade);
	}

	public String getDepartment() {
		return department;
	}

	public String getResearchArea() {
		return researchArea;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int years) {
		this.yearsOfExperience = years;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + String.format(", Department: %s, Research: %s, Experience: %d years", department,
				researchArea, yearsOfExperience);
	}
}
