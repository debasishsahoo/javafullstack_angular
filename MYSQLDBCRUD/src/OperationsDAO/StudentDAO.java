package OperationsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Configuration.MysqlConfig;
import Entity.Student;

public class StudentDAO {

	// CREATE
	public void addStudent(Student student) {
		String query = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
		try (Connection conn = MysqlConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
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

	// READ ALL
	public void getAllStudents() {
		String query = "SELECT * FROM students";

		try (Connection conn = MysqlConfig.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			System.out.println("\n===== ALL STUDENTS =====");
			boolean hasRecords = false;

			while (rs.next()) {
				hasRecords = true;
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
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

	// READ BY ID
	public void getStudentById(int id) {
		String query = "SELECT * FROM students WHERE id = ?";
		try (Connection conn = MysqlConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getInt("age"));
				System.out.println("\n" + student + "\n");
			} else {
				System.out.println("No student found with ID: " + id);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving student: " + e.getMessage());
		}
	}
	
	// UPDATE
    public void updateStudent(int id, String name, String email, int age) {
        String query = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
        
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Student updated successfully!");
            } else {
                System.out.println("No student found with ID: " + id);
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
    
    // DELETE
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✓ Student deleted successfully!");
            } else {
                System.out.println("No student found with ID: " + id);
            }
            
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
