package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiCatchDifferentExceptions {

	public static void main(String[] args) {
		try {
			// Example 1: File operation (may cause IOException)
			FileInputStream file = new FileInputStream("nonexistent.txt");
			int data = file.read();
			System.out.println("Data: " + data);
			file.close();

			// Example 2: Database connection (may cause SQLException)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1234");
			conn.close();

		} catch (IOException | SQLException e) {
			System.out.println("An error occurred: " + e.getMessage());
			
			// You can still differentiate using 'instanceof'
            if (e instanceof IOException) {
                System.out.println("This is an IO-related problem (e.g., file not found)");
            } 
            else if (e instanceof SQLException) {
                System.out.println("This is a Database-related problem (e.g., invalid connection)");
            }
			
			
			
			
		} catch (Exception e) {
			System.out.println("General exception");
		}

	}

}
