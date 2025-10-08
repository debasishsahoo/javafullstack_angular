
public class Main {
	public static void main(String[] args) {
		try {
			// Connect to MongoDB
			DatabaseConfig.connect();
			// Display welcome message
			UIHelper.displayWelcome();
			// Initialize service
			StudentService service = new StudentService();
			// Main menu loop
			boolean running = true;
			while (running) {
				UIHelper.displayMenu();
				int choice = InputHelper.getIntInput("Enter your choice: ");
				switch (choice) {
				case 1:
					service.createStudent();
					break;
				case 2:
					service.readAllStudents();
					break;
				case 3:
					service.readStudentById();
					break;
				case 4:
					service.searchStudentsByName();
					break;
				case 5:
					service.filterStudentsByGrade();
					break;
				case 6:
					service.updateStudent();
					break;
				case 7:
					service.updateStudentMarks();
					break;
				case 8:
					service.deleteStudent();
					break;
				case 9:
					service.deleteStudentsByGrade();
					break;
				case 10:
					service.getStatistics();
					break;
				case 11:
					running = false;
					System.out.println("\nThank you for using Student Management System!");
					System.out.println("Goodbye! ");
					break;
				default:
					System.out.println(" Invalid choice! Please try again.");
				}
				if (running) {
					System.out.println("\nPress Enter to continue...");
					InputHelper.getStringInput("");
				}
			}
		} catch (Exception e) {
			System.out.println(" Application Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Close connections
			DatabaseConfig.close();
			InputHelper.close();
		}
	}
}
