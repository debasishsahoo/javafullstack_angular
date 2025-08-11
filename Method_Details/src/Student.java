
/**
 * Student class demonstrating various method types Shows instance methods,
 * constructors, getters/setters, overriding
 */

public class Student {
	// Instance variables
	private int id;
	private String name;
	private int age;
	private double[] grades;
	private static int totalStudents = 0; // Static variable

	// 1. CONSTRUCTOR METHODS

	// Default constructor
	public Student() {
		this.id = ++totalStudents;
		this.name = "Unknown";
		this.age = 18;
		this.grades = new double[5];
		System.out.println("Default constructor called for Student ID: " + this.id);
	}

	// Parameterized constructor - CONSTRUCTOR OVERLOADING
	public Student(String name, int age) {
		this.id = ++totalStudents;
		this.name = name;
		this.age = age;
		this.grades = new double[5];
		System.out.println("Parameterized constructor called for: " + name + " and Age: " + age);
	}

	// Full constructor
	public Student(String name, int age, double[] grades) {
		this.id = ++totalStudents;
		this.name = name;
		this.age = age;
		this.grades = grades.clone(); // Defensive copying
		System.out.println("Full constructor called for: " + name + " and Age: " + age + " and Grade" + grades);
	}

	// 2. GETTER METHODS (ACCESSOR METHODS)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double[] getGrades() {
		return grades.clone();
	} // Return copy for security

	// 3. SETTER METHODS (MUTATOR METHODS)
	public void setName(String name) {
		validateName(name); // Using private helper method
		this.name = name;
	}

	public void setAge(int age) {
		if (age < 16 || age > 100) {
			throw new IllegalArgumentException("Age must be between 16 and 100");
		}
		this.age = age;
	}

	
	
	// 4. PRIVATE HELPER METHODS
	private void validateName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		if (name.length() < 2) {
			throw new IllegalArgumentException("Name must be at least 2 characters");
		}
	}

	
	
	
	
	
	
	public static void main(String[] args) {
		Student stuObj1 = new Student();
		Student stuObj2 = new Student("Deb", 34);

	}

}
