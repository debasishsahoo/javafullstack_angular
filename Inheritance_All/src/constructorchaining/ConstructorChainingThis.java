package constructorchaining;

class Student {
	private String name;
	private int age;
	private String course;

	// Default constructor
	public Student() {
		this("Unknown", 0, "Not Assigned"); // Calls 3-parameter constructor
	}

	// Constructor with only name
	public Student(String name) {
		this(name, 0, "Not Assigned"); // Calls 3-parameter constructor
	}

	// Full constructor
	public Student(String name, int age, String course) {
		this.name = name;
		this.age = age;
		this.course = course;
		System.out.println("Student created: " + name + ", " + age + ", " + course);
	}

}

public class ConstructorChainingThis {

	public static void main(String[] args) {
		System.out.println("=== Creating Student with default constructor ===");
        Student s1 = new Student();

        System.out.println("\n=== Creating Student with only name ===");
        Student s2 = new Student("Alice");

        System.out.println("\n=== Creating Student with full details ===");
        Student s3 = new Student("Bob", 21, "Computer Science");
	}

}


//this(...) must always be the first statement in a constructor.
//It helps to reuse constructor logic instead of duplicating initialization code.
//This pattern is called constructor chaining (inside the same class).



