package ValidationSetters;

public class Student {
	private String email;
	private int grade;
	private String studentId;

	public void setEmail(String email) {
		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("Invalid email format");
		}
		this.email = email.toLowerCase().trim();
	}

	public void setGrade(int grade) {
		if (grade < 0 || grade > 100) {
			throw new IllegalArgumentException("Grade must be between 0 and 100");
		}
		this.grade = grade;
	}

	public void setStudentId(String studentId) {
		if (studentId == null || !studentId.matches("^STU\\d{6}$")) {
			throw new IllegalArgumentException("Student ID must match pattern STU######");
		}
		this.studentId = studentId;
	}
	
	
	
	
	

}
