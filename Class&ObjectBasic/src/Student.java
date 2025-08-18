
// CLASS DEFINITION - Blueprint for creating Student objects
public class Student {

	// 1. Fields/Attributes
	// INSTANCE VARIABLES (Fields/Attributes)
	// These define the STATE of each Student object
	private String studentId; // Unique identifier
	private String name; // Student's name
	private int age; // Student's age
	private double gpa; // Grade Point Average
	private String[] courses; // Array of enrolled courses
	private int courseCount; // Number of courses enrolled

	// STATIC VARIABLES (Class variables)
	// Shared among all instances of the class
	private static int totalStudents = 0; // Keeps track of total students
	private static final String UNIVERSITY = "Tech University"; // Constant

	// 2. Constructor
	// DEFAULT CONSTRUCTOR
	// Called when object is created without parameters: new Student()
	public Student() {
		this.name = "Unknown";
		this.age = 18;
		this.studentId = "STU" + (totalStudents + 1);
		this.gpa = 0.0;
		this.courses = new String[10]; // Maximum 10 courses
		this.courseCount = 0;
		totalStudents++; // Increment total count
		System.out.println("Default constructor called - Student created");
	}

	// PARAMETERIZED CONSTRUCTOR
	// Called when object is created with parameters
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.studentId = "STU" + (totalStudents + 1);
		this.gpa = 0.0;
		this.courses = new String[10];
		this.courseCount = 0;
		totalStudents++;
		System.out.println("Parameterized constructor called - Student " + name + " created");
	}

	// OVERLOADED CONSTRUCTOR
	// Another version with more parameters
	public Student(String name, int age, String studentId, double gpa) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		this.gpa = gpa;
		this.courses = new String[10];
		this.courseCount = 0;
		totalStudents++;
		System.out.println("Overloaded constructor called - Student " + name + " created");
	}

	// GETTER METHODS (Accessors)
	// Provide controlled access to private fields
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public double getGpa() {
		return this.gpa;
	}

	// SETTER METHODS (Mutators)
	// Allow controlled modification of private fields
	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		} else {
			System.out.println("Invalid name provided");
		}
	}

	public void setAge(int age) {
		if (age > 0 && age < 120) {
			this.age = age;
		} else {
			System.out.println("Invalid age. Age must be between 1 and 119");
		}
	}

	public void setGpa(double gpa) {
		if (gpa >= 0.0 && gpa <= 4.0) {
			this.gpa = gpa;
		} else {
			System.out.println("Invalid GPA. GPA must be between 0.0 and 4.0");
		}
	}
	
	

	// BEHAVIOR METHODS (Instance methods)
	// Define what a Student object can DO
	public void enrollInCourse(String courseName) {
		if (courseCount < courses.length) {
			courses[courseCount] = courseName;
			courseCount++;
			System.out.println(name + " enrolled in " + courseName);
		} else {
			System.out.println("Cannot enroll. Maximum course limit reached.");
		}
	}

}
