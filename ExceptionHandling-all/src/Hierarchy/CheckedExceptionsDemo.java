package Hierarchy;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckedExceptionsDemo {
	public static void main(String[] args) {

		// IOException - File operations
		try {
			FileInputStream file = new FileInputStream("data.txt");
			file.read();
			file.close();
		} catch (IOException e) {
			System.out.println("File operation failed: " + e.getMessage());
		}
		
		
		
		// SQLException - Database operations
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String password = "password";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			System.out.println("Database connection successful!");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}

		// ClassNotFoundException - Dynamic class loading
		
		try {
            Class.forName("com.example.MyClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
		
		

		// ParseException - Date parsing
		
		
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2025-13-45"); // Invalid date (month 13)
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
        }

		
		
		
		
		
		
		
		
		
	}

}
