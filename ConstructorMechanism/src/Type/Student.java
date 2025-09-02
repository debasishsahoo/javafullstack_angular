package Type;

public class Student {
	private String name;
	private int age;

	// Java automatically provides this if no constructor is written:
	// Implicit no-argument constructor
	// public Student() {
	// super();
	// }

	// Explicit no-argument constructor
	public Student() {
		System.out.println("Student object created");
	}

	// Parameterized constructor
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }

}
