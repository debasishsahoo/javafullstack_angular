package Basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Multi_Catch {

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

		//multi-catch operator (a single vertical bar)
		//After Java 7 (Old Way)
	   //All exception types must be unrelated (i.e., one should not be a subclass of another).
	  //The exception variable e is final — you cannot reassign it inside the block.
		} catch (IOException | SQLException e) {
			System.out.println("Database or File Not Found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("General exception");
		}

	}

}
