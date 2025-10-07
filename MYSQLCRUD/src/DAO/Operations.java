package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Configuration.MySqlConfig;
import Entity.Student;

public class Operations {

	private String INSERTQUERY = "INSERT INTO students(name,email,age) VALUES (?,?,?)";
	private String SELECTQUERY = "SELECT * FROM students";
	private String WHEREQUERY = "SELECT * FROM students WHERE id = ?";
	private String UPDATEQUERY = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
	private String DELETEQUERY = "DELETE FROM students WHERE id = ?";

	// Data INSERT(Create)
	public void addStudent(Student student) {
		try (Connection conn = MySqlConfig.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(INSERTQUERY)) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setInt(3, student.getAge());
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println(" Student added successfully!");
			}

		} catch (SQLException e) {
			System.out.println("Error adding student: " + e.getMessage());
		}
	}

	// Data VIEW(View All Record)
	public void getAllStudents() {
		try (Connection conn = MySqlConfig.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECTQUERY)
		) {
			System.out.println("\n===== ALL STUDENTS =====");
			boolean hasRecords = false;
			while (rs.next()) {
				hasRecords = true;
				Student student = new Student(rs.getInt("id"), 
						rs.getString("name"), rs.getString("email"),
						rs.getInt("age"));
				System.out.println(student);
			}
			
			if (!hasRecords) {
				System.out.println("No students found.");
			}
			System.out.println("========================\n");
			
		} catch (SQLException e) {
			System.out.println("Error retrieving students: " + e.getMessage());
		}

	}

	// Data VIEW(View Single Record)
	public void getStudentById(int id) {

	}

	// Data UPDATE(Update Single Record)
	public void updateStudent(int id, String name, String email, int age) {

	}

	// Data DELETE(Delete Single Record)
	public void deleteStudent(int id) {
	}
}
