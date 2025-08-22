package InstanceVariables;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("John", 20, "john@email.com");

		// Accessing public instance variable
		System.out.println(student.name); // "John"

		// Accessing private variable through public method
		System.out.println(student.getAge()); // 20
		
		// student.age; // Compilation error - private access
}
}
