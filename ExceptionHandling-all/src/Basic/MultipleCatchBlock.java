package Basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MultipleCatchBlock {
//Catch blocks should be ordered from most specific to most general.
	public static void main(String[] args) {
		try {
			// Risky code: trying to open a file that may not exist
			FileInputStream file = new FileInputStream("nonexistent.txt");
			
			int data = file.read();
			System.out.println("Data: " + data);
			file.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
            System.out.println("IO error");
        } 
		catch (Exception e) {
			System.out.println("General exception");
		}
		 System.out.println("Program continues after exception handling...");
	}

}
