
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
		// Using default constructor
		Student student1 = new Student();
		// Using parameterized constructor
		Student student2 = new Student("Alice Johnson", 20);
		// Using overloaded constructor
		Student student3 = new Student("Bob Smith", 22, "STU001", 3.8);

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

		System.out.println("\n4. Object Interactions:");
		System.out.println("------------------------");
		// Objects can interact with each other
		Student betterStudent = Student.getBetterStudent(student2, student3);
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
