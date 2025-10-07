
// Main Application Class

import java.util.Scanner;

public class CRUDApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeDAO employeeDAO = new EmployeeDAO();

		System.out.println("EMPLOYEE MANAGEMENT SYSTEM");

		while (true) {
			System.out.println("========== MENU ==========");
			System.out.println("1. Add Employee (CREATE)");
			System.out.println("2. View All Employees (READ)");
			System.out.println("3. View Employee by ID (READ)");
			System.out.println("4. View Employees by Department (READ)");
			System.out.println("5. Update Employee (UPDATE)");
			System.out.println("6. Delete Employee (DELETE)");
			System.out.println("7. View Department Statistics");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1: // CREATE
				System.out.println("\n--- Add New Employee ---");
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter email: ");
				String email = scanner.nextLine();
				System.out.print("Enter department: ");
				String department = scanner.nextLine();
				System.out.print("Enter salary: ");
				double salary = scanner.nextDouble();

				Employee newEmployee = new Employee(name, email, department, salary);
				employeeDAO.addEmployee(newEmployee);
				break;

			case 2: // READ ALL
				employeeDAO.getAllEmployees();
				break;

			case 3: // READ BY ID
				System.out.print("Enter employee ID: ");
				int searchId = scanner.nextInt();
				employeeDAO.getEmployeeById(searchId);
				break;

			case 4: // READ BY DEPARTMENT
				System.out.print("Enter department name: ");
				String searchDept = scanner.nextLine();
				employeeDAO.getEmployeesByDepartment(searchDept);
				break;

			case 5: // UPDATE
				System.out.println("\n--- Update Employee ---");
				System.out.print("Enter employee ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter new name: ");
				String newName = scanner.nextLine();
				System.out.print("Enter new email: ");
				String newEmail = scanner.nextLine();
				System.out.print("Enter new department: ");
				String newDepartment = scanner.nextLine();
				System.out.print("Enter new salary: ");
				double newSalary = scanner.nextDouble();

				employeeDAO.updateEmployee(updateId, newName, newEmail, newDepartment, newSalary);
				break;

			case 6: // DELETE
				System.out.print("Enter employee ID to delete: ");
				int deleteId = scanner.nextInt();
				System.out.print("Are you sure? (yes/no): ");
				scanner.nextLine();
				String confirm = scanner.nextLine();
				if (confirm.equalsIgnoreCase("yes")) {
					employeeDAO.deleteEmployee(deleteId);
				} else {
					System.out.println("Deletion cancelled.");
				}
				break;

			case 7: // STATISTICS
				employeeDAO.getStatistics();
				break;

			case 8: // EXIT
				System.out.println("\nThank you for using the Employee Management System!");
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please try again.");
			}

			System.out.println();
		}
	}
}