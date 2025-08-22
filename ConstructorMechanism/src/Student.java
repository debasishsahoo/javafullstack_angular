public class Student {
	private String name;
	private int age;
	private char surname;

	// Default constructor
	public Student() {
		this.name = "Unknown";
		this.age = 0;
	}

	// Parameterized constructor
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Constructor chaining
	public Student(String name) {
		this(name, 18); // Calls the parameterized constructor
	}

	public static void main(String[] args) {

		Student stu1 = new Student();// Default constructor
		System.out.println("Deault Student: " + stu1.name);
		System.out.println("Deault Student: " + stu1.age);
		
		Student stu2 = new Student("Deb",16);// Parameterized constructor
		System.out.println("Parameterized Student: " + stu2.name);
		System.out.println("Parameterized Student: " + stu2.age);
		
		
		Student stu3 = new Student("Debasish");// Constructor chaining
		System.out.println("Parameterized Student: " + stu3.name);
		System.out.println("Parameterized Student: " + stu3.age);
		
		//If you don't provide any constructor, Java creates a default no-argument constructor
		//Once you define any constructor, the default constructor is no longer provided
		//Constructors cannot be inherited but can be called using super()
		//Constructor chaining uses this() or super() and must be the first statement	
		
	}

}
