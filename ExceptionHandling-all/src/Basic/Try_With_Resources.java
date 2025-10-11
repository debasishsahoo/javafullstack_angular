package Basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//(introduced in Java 7+)
//Any object declared inside the parentheses must implement the AutoCloseable or 
//Closeable interface (like BufferedReader, FileReader, Scanner, etc.).
//When the try block finishes (even if an exception occurs), Java automatically closes those resources
//— so you don’t need a finally block to close them manually.
public class Try_With_Resources {
	// Try-with-resources: automatically closes the resource
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
			String line = br.readLine();
            System.out.println("First line: " + line);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("First line: " + e.getMessage());
		}
		
		System.out.println("Program finished successfully");
	}
}
