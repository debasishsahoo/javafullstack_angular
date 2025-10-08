import java.util.List;

public class UIHelper {
	public static void displayWelcome() {
		System.out.println("STUDENT MANAGEMENT SYSTEM MongoDB Edition");
	}

	public static void displayMenu() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println(" MAIN MENU");
		System.out.println("=".repeat(50));
		System.out.println(" CREATE Operations:");
		System.out.println("1.Add New Student");
		System.out.println("\nREAD Operations:");
		System.out.println("2.View All Students");
		System.out.println("3.  View Student by ID");
		System.out.println("4.  Search Students by Name");
		System.out.println("5. Filter Students by Grade");
		System.out.println("\nUPDATE Operations:");
		System.out.println("6.   Update Student Information");
		System.out.println("7. Update Student Marks");
		System.out.println("\n DELETE Operations:");
		System.out.println("8.   Delete Student");
		System.out.println("9.  Delete Students by Grade");
		System.out.println("\n  OTHER:");
		System.out.println("10.  View Statistics");
		System.out.println("11.  Exit");
		System.out.println("=".repeat(50));
	}

	public static void displayStudentsTable(List<Student> students) {
		if (students.isEmpty()) {
			System.out.println(" No students found.");
			return;
		}

		System.out.printf("%-26s | %-20s | %-4s | %-8s | %-25s | %-6s | %-15s%n", "ID", "Name", "Age", "Grade", "Email",
				"Marks", "City");
		System.out.println("-".repeat(120));

		for (Student student : students) {
			System.out.println(student.toTableRow());
		}

		System.out.println("-".repeat(120));
		System.out.println(" Total: " + students.size());
	}
	
	public static void displayHeader(String title) {
        System.out.println("\n" + "=".repeat(120));
        System.out.println(centerText(title, 120));
        System.out.println("=".repeat(120));
    }
    
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }
}
