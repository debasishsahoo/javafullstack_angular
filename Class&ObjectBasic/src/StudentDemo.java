
public class StudentDemo {
	public static void main(String[] args) {
		System.out.println("=== JAVA CLASS vs OBJECT DEMONSTRATION ===\n");

		// CLASS: Student is the blueprint/template
		// It defines what attributes and methods a student should have
		// The class itself doesn't take memory until objects are created

		System.out.println("1. Creating Objects (Instances of Student class):");
		System.out.println("-------------------------------------------------");
		// OBJECTS: Actual instances created from the Student class
		// Each object has its own memory space and data

		
		
		
		
		
		// (a) Declaration ( Student student0; )

		// 1.1 Declaring a reference variable. named student0 of type Student.
		// 1.2 Student is a Custom Data type
		// 1.3 Class is a Custom Data type ;
		// 1.4 like c language Structure

		// 2.1 student0 is not an object yet; it’s just a reference that can point to a
		// Student object
		// 2.2 Think of it as a remote control (reference) that will be linked to an
		// actual TV (object) later.

		// 3.1 This creates a reference variable in the stack memory.
		// 3.2 student0 itself is very small — it only stores a memory address (like a
		// pointer).
		// 3.3 Before assignment, it contains null.
		// 3.4 So yes, student0 occupies a small amount of memory,
		// ...but only enough to hold an address (not the whole object).

		Student student0; // Null
		

		//System.out.println("student0:"+student0);
		
		
		
		
		// (b) Instantiation( new Student(); )

		// 1.1 The keyword new dynamically allocates memory for a new Student object on
		// the heap.

		// 2.1 Student() calls the constructor of the class.
		// 2.2 The constructor initializes the object (sets up its default or provided
		// values).

		// 3.1 A reference (memory address) to that newly created object is returned by
		// new.

		// 4.1 The memory allocated depends on the instance variables inside Student.

		/*
		 * class Student { 
		 * String name; // reference (memory for storing an address) 
		 * int age; // 4 bytes typically }
		 * 
		 * new Student();
		 * 
		 * So, in heap memory, space is reserved for:
		 * The int age (primitive directly stored, e.g., 4 bytes)
		 * The String name (just a reference here, actual characters of the string are elsewhere in heap/constant pool)
		 * Plus some extra object overhead (JVM metadata like object header).
		 * With the Help of  Student() Constructor
		 */

		Student student1 = new Student(); // Using default constructor

		System.out.println("student1:"+student1);
		//Instantiation With Default Value
		
		// Memory Picture
		// Stack (short-lived, method-level)             Heap (long-lived, global until GC)
		// student1 ------------------------------>      [ Student object ]
		//                                                   ├─ name : null (until set)
		//                                                   ├─ age  : 0
		
		//student1 (the reference variable) does occupy memory, 
		//but very small (just enough to store an address, typically 4 or 8 bytes depending on JVM architecture).
		
		
		//The real memory is taken up by the object in the heap.
		
		
		
		
		//(c) Assignment
		
		// student1 = (the reference returned by new Student())
		
		//The reference (address) from new Student() is stored in the variable student1.
		//Now student1 "points to" that object in memory.
		//If you print student1, you won’t see the object
		//itself but something like Student@6d06d69c (a memory reference).
		
		
		
		
		//4. Lifecycle
		//1. Declaration → reference variable created (student1).
		//2. Instantiation → new object created in heap.
		//3. Assignment → reference is linked to that object.
		
		//4. Now student1 can access object fields and methods:
		
		//(Current Object or this =student1)
		//student1.name = "Unknown";
		//student1.age = 20;
		
		
		
		// Student student1; → Only declares the reference (no object yet).
		// new Student(); → Creates an object but without a reference, it’s eligible for garbage collection.
		// Student student1 = new Student(); → Combines declaration, instantiation, and assignment.
		//Every object created with new goes into heap memory.
		//The variable (student1) is just a pointer/reference.
		
		
		
		
		
		// Using parameterized constructor
		Student student2 = new Student("Alice Johnson", 20);
		// Using overloaded constructor
		Student student3 = new Student("Bob Smith", 22, "STU001", 3.8);
		
		
		
		
		
        //object represents its data or attributes at a given point in time
		//These are usually stored in instance variables (fields) of the class.
		//Defined by: Fields (variables) of the class.
		//Represents: Current values of the object.
		//Changes: The state can change during the lifetime of the object using methods.
		
		System.out.println("\n2. Object State and Behavior:");
		System.out.println("--------------------------------");
		
		
		// Each object maintains its own state (data)
		student1.setName("Charlie Brown");
		student1.setAge(19);
		student1.setGpa(3.2);
		
		// Objects can perform behaviors (methods)
		student1.enrollInCourse("Java Programming");
		student1.enrollInCourse("Data Structures");
		
		
		student2.enrollInCourse("Calculus");
		student2.enrollInCourse("Physics");
		student2.setGpa(3.7);
		
		
		student3.enrollInCourse("Advanced Java");
		student3.study("Java", 5);

		
		
		System.out.println("\n3. Individual Object Information:");
		System.out.println("-----------------------------------");
		// Each object has its own unique state
		student1.displayStudentInfo();
		student2.displayStudentInfo();
		student3.displayStudentInfo();
		
		
		//Object interaction occurs when one object uses another object to perform a task.
		  //By calling methods of another object.
		  //By passing objects as arguments to methods.
		  //By returning objects from methods.
		  //By holding references to other objects as fields.
	
	
		System.out.println("\n4. Object Interactions:");
		System.out.println("------------------------");
		// Objects can interact with each other
		Student betterStudent = Student.getBetterStudent(student2, student3);//Object Passing 
		if (betterStudent != null) {
			System.out.println("Better student: " + betterStudent.getName() + " (GPA: " + betterStudent.getGpa() + ")");
		} else {
			System.out.println("Both students have equal GPA");
		}

		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n5. Static (Class-level) vs Instance data:");
		System.out.println("------------------------------------------");
		// Static methods belong to the class, not individual objects
		Student.displayUniversityInfo();
		
		
		
		
		
		

		System.out.println("\n6. Object Uniqueness:");
		System.out.println("----------------------");
		// Each object is unique, even if created from the same class
		System.out.println("student1 == student2: " + (student1 == student2));
		System.out.println("student1.equals(student2): " + student1.equals(student2));

		
		
		
		System.out.println("\n7. Object String Representation:");
		System.out.println("----------------------------------");
		System.out.println("className@hashCode");
		System.out.println("student1: " + student1.toString());
		System.out.println("student2: " + student2.toString());
		System.out.println("student3: " + student3.toString());
		
		
		
		

		System.out.println("\n8. Memory and Object References:");
		System.out.println("----------------------------------");

		// Creating another reference to the same object
		Student student1Ref = student1;
		System.out.println("student1 == student1Ref: " + (student1 == student1Ref));

		// Modifying through one reference affects the object
		student1Ref.setGpa(3.9);
		System.out.println("student1 GPA after modification through reference: " + student1.getGpa());

		
		
		
		
		
		
		
		
		
		System.out.println("\n=== KEY CONCEPTS SUMMARY ===");
		System.out.println("• CLASS: Blueprint/Template (Student class)");
		System.out.println("• OBJECT: Actual instance with memory (student1, student2, student3)");
		System.out.println("• Each object has its own state (different values for name, age, etc.)");
		System.out.println("• All objects share the same behavior (methods from the class)");
		System.out.println("• Static members belong to the class, not individual objects");
		System.out.println("• Objects can be created, modified, and destroyed independently");

	}
}
