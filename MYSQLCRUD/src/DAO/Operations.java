package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public void getAllStudent() {
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
