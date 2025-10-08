import java.util.List;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		this.studentDAO = new StudentDAO();
	}

	public void createStudent() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("           ADD NEW STUDENT");
		System.out.println("=".repeat(50));

		try {
			String name = InputHelper.getStringInput("Enter student name: ");
			int age = InputHelper.getIntInput("Enter age: ");
			String grade = InputHelper.getStringInput("Enter grade (e.g., 10th, 11th, 12th): ");
			String email = InputHelper.getStringInput("Enter email: ");
			double marks = InputHelper.getDoubleInput("Enter marks (0-100): ");
			String city = InputHelper.getStringInput("Enter city: ");

			Student student = new Student(name, age, grade, email, marks, city);
			String id = studentDAO.addStudent(student);

			System.out.println("\n Student added successfully!");
			System.out.println(" Student ID: " + id);
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void readAllStudents() {
		UIHelper.displayHeader("ALL STUDENTS");
		try {
			List<Student> students = studentDAO.getAllStudents();
			UIHelper.displayStudentsTable(students);
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void readStudentById() {
		String id = InputHelper.getStringInput("\nEnter student ID: ");

		try {
			Student student = studentDAO.getStudentById(id);
			if (student != null) {
				System.out.println("\n" + "=".repeat(50));
				System.out.println("           STUDENT DETAILS");
				System.out.println("=".repeat(50));
				System.out.println(student.toDetailedView());
			} else {
				System.out.println(" No student found with ID: " + id);
			}
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void searchStudentsByName() {
		String name = InputHelper.getStringInput("\nEnter name to search: ");

		try {
			UIHelper.displayHeader("SEARCH RESULTS FOR: " + name);
			List<Student> students = studentDAO.searchByName(name);
			UIHelper.displayStudentsTable(students);
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void filterStudentsByGrade() {
		String grade = InputHelper.getStringInput("\nEnter grade to filter: ");

		try {
			UIHelper.displayHeader("STUDENTS IN GRADE: " + grade.toUpperCase());
			List<Student> students = studentDAO.filterByGrade(grade);
			UIHelper.displayStudentsTable(students);
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void updateStudent() {
		String id = InputHelper.getStringInput("\nEnter student ID to update: ");

		try {
			Student existing = studentDAO.getStudentById(id);
			if (existing == null) {
				System.out.println(" No student found with ID: " + id);
				return;
			}

			System.out.println("\n--- Current Information ---");
			System.out.println(existing.toDetailedView());

			System.out.println("\n--- Enter New Information ---");
			String name = InputHelper.getStringInput("Enter new name: ");
			int age = InputHelper.getIntInput("Enter new age: ");
			String grade = InputHelper.getStringInput("Enter new grade: ");
			String email = InputHelper.getStringInput("Enter new email: ");
			double marks = InputHelper.getDoubleInput("Enter new marks: ");
			String city = InputHelper.getStringInput("Enter new city: ");

			boolean updated = studentDAO.updateStudent(id, name, age, grade, email, marks, city);

			if (updated) {
				System.out.println("\n Student updated successfully!");
			} else {
				System.out.println(" No changes were made.");
			}
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void updateStudentMarks() {
		String id = InputHelper.getStringInput("\nEnter student ID: ");

		try {
			Student existing = studentDAO.getStudentById(id);
			if (existing == null) {
				System.out.println(" No student found with ID: " + id);
				return;
			}

			System.out.println("\nCurrent Marks: " + existing.getMarks());
			double newMarks = InputHelper.getDoubleInput("Enter new marks (0-100): ");

			boolean updated = studentDAO.updateMarks(id, newMarks);

			if (updated) {
				System.out.println(" Marks updated successfully!");
			} else {
				System.out.println(" No changes were made.");
			}
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void deleteStudent() {
		String id = InputHelper.getStringInput("\nEnter student ID to delete: ");

		try {
			Student student = studentDAO.getStudentById(id);
			if (student == null) {
				System.out.println(" No student found with ID: " + id);
				return;
			}

			System.out.println("\n--- Student to be deleted ---");
			System.out.println(student.toDetailedView());

			String confirm = InputHelper.getStringInput("\n⚠️ Delete this student? (yes/no): ");

			if (confirm.equalsIgnoreCase("yes")) {
				boolean deleted = studentDAO.deleteStudent(id);
				if (deleted) {
					System.out.println(" Student deleted successfully!");
				} else {
					System.out.println(" Failed to delete student.");
				}
			} else {
				System.out.println(" Deletion cancelled.");
			}
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void deleteStudentsByGrade() {
		String grade = InputHelper.getStringInput("\nEnter grade to delete all students: ");

		try {
			long count = studentDAO.countByGrade(grade);

			if (count == 0) {
				System.out.println(" No students found in grade: " + grade);
				return;
			}

			System.out.println("\n This will delete " + count + " student(s) in grade " + grade);
			String confirm = InputHelper.getStringInput("Are you sure? (yes/no): ");

			if (confirm.equalsIgnoreCase("yes")) {
				long deleted = studentDAO.deleteByGrade(grade);
				System.out.println(" " + deleted + " student(s) deleted successfully!");
			} else {
				System.out.println(" Deletion cancelled.");
			}
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}

	}

	public void getStatistics() {
		try {
			System.out.println("\n" + "=".repeat(60));
			System.out.println("                DATABASE STATISTICS");
			System.out.println("=".repeat(60));

			StudentStatistics stats = studentDAO.getStatistics();
			System.out.println(stats);

			System.out.println("=".repeat(60));
		} catch (Exception e) {
			System.out.println(" " + e.getMessage());
		}
	}

}
