
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
        Student student3 = new Student("Bob Smith",22, "STU001", 3.8);
        
        
        
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
        
	}
}
