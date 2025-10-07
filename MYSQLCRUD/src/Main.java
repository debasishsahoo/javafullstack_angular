import java.util.Scanner;

import DAO.Operations;
import Entity.Student;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Operations dao=new Operations();
		System.out.println("STUDENT MANAGEMENT SYSTEM");
		while (true) {
			System.out.println("===== MENU =====");
			System.out.println("1. Add Student (CREATE)");
			System.out.println("2. View All Students (READ)");
			System.out.println("3. View Student by ID (READ)");
			System.out.println("4. Update Student (UPDATE)");
			System.out.println("5. Delete Student (DELETE)");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline
			switch (choice) {
			case 1: // CREATE
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter email: ");
				String email = scanner.nextLine();
				System.out.print("Enter age: ");
				int age = scanner.nextInt();

				Student newStudent = new Student(name, email, age);
				dao.addStudent(newStudent);
				break;
				
			case 2: // READ ALL
				dao.getAllStudents();
				break;
				
			case 3: // READ BY ID
				System.out.print("Enter student ID: ");
				int searchId = scanner.nextInt();
				dao.getStudentById(searchId);
				break;
				
			case 4: // UPDATE
				System.out.print("Enter student ID to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter new name: ");
				String newName = scanner.nextLine();
				System.out.print("Enter new email: ");
				String newEmail = scanner.nextLine();
				System.out.print("Enter new age: ");
				int newAge = scanner.nextInt();

				dao.updateStudent(updateId, newName, newEmail, newAge);
				break;
				
			case 5: // DELETE
				System.out.print("Enter student ID to delete: ");
				int deleteId = scanner.nextInt();
				dao.deleteStudent(deleteId);
				break;
				
			case 6: // EXIT
				System.out.println("Thank you for using the system. Goodbye!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}

			System.out.println();
		}

	}
}

