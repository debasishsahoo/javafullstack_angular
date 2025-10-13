package Basic;

import java.io.FileReader;
import java.io.IOException;

//throws keyword is used in a method signatur
//to tell the caller that the method might throw one or more exceptions.
public class Usethrows {
	// Method declares that it may throw IOException
	public void readFile() throws IOException {

		FileReader file = new FileReader("file.txt");
		int data = file.read();
		System.out.println("First character: " + (char) data);
		file.close();
	}

	public static void main(String[] args) {
		Usethrows example = new Usethrows();
		try {
			example.readFile();
		} catch (IOException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

	}
//throws IOException tells Java that this method might cause an IOException.
// The caller (in this case, the main method) must handle it with a try-catch block.
	
//throw:Actually throwing an exception,
	   //inside a method or block
	  //A single exception object
	  //Current or caller method
	
	
//throws:Declaring that a method may throw exceptions,
	   //In the method signature
	   //One or more exception class names
	   //Caller method (must handle or declare again)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
