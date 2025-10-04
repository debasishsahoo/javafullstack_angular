package StaticVariable;

public class Student {
	static String schoolName = "ABC High School"; // public static
	private static int totalStudents = 0; // private static
	protected static final String SCHOOL_CODE = "ABC01"; // static final (constant)
	static boolean isSchoolOpen; // package-private static
}

class Counter {
	static int staticCount = 0; // One copy in Method Area
	int instanceCount = 0; // Separate copy for each object in Heap

	public Counter() {
		staticCount++; // Increments the shared copy
		instanceCount++; // Increments this object's copy
	}
}
//Counter c1 = new Counter();  staticCount= 1; instanceCount= 1;
//Counter c2 = new Counter();  staticCount= 2; instanceCount= 1;
//Counter c3 = new Counter();  staticCount= 3; instanceCount= 1;

class Example {
	// Static variable - shared by all objects of the class
	static int count = 10;

	public static void main(String[] args) {
		// Accessing static variable using class name (Recommended)
		System.out.println("Static variable value: " + Example.count);

		// Creating objects (static variable remains shared)
		Example obj1 = new Example();
		Example obj2 = new Example();

		// Modifying static variable using class name
		Example.count = 20;

		// Accessing through objects (not recommended, but possible)
		System.out.println("Access via obj1: " + obj1.count);
		System.out.println("Access via obj2: " + obj2.count);
		System.out.println("Access via class name: " + Example.count);
	}
}

class Example2 {
	// Static variable - belongs to the class
	static int count = 10;

	// Instance method
	public void displayCount() {
		// Direct access to static variable
		System.out.println("Direct access: " + count);

		// Accessing using class name (recommended for clarity)
		System.out.println("Access via class name: " + Example2.count);
	}

	// Main method
	public static void main(String[] args) {
		// Create an object to call instance method
		Example2 obj = new Example2();
		obj.displayCount();
	}

}
