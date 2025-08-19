
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

	public void dropCourse(String courseName) {
		for (int i = 0; i < courseCount; i++) {
			if (courses[i].equals(courseName)) {
				// Shift all elements left to fill the gap
				for (int j = i; j < courseCount - 1; j++) {
					courses[j] = courses[j + 1];
				}
				courses[courseCount - 1] = null; // Clear last element
				courseCount--;
				System.out.println(name + " dropped " + courseName);
				return;
			}
		}
		System.out.println(name + " is not enrolled in " + courseName);
	}

	
	//Print object-specific information
	public void displayStudentInfo() {
		System.out.println("\n=== Student Information ===");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Student ID: " + studentId);
		System.out.println("GPA: " + gpa);
		System.out.println("University: " + UNIVERSITY);
		System.out.println("Enrolled Courses (" + courseCount + "):");

		if (courseCount == 0) {
			System.out.println("  No courses enrolled");
		} else {
			for (int i = 0; i < courseCount; i++) {
				System.out.println("  - " + courses[i]);
			}
		}
		System.out.println("========================\n");
	}

	public boolean isHonorStudent() {
		return gpa >= 3.5;
	}

	public void study(String subject, int hours) {
		System.out.println(name + " studied " + subject + " for " + hours + " hours");
		// Simulate GPA improvement
		if (hours > 0) {
			double improvement = hours * 0.01; // 0.01 GPA per hour
			double newGpa = Math.min(4.0, gpa + improvement);
			setGpa(newGpa);
		}
	}

	// STATIC METHODS (Class methods)
	// Belong to the class, not to any specific instance
	public static int getTotalStudents() {
		return totalStudents;
	}

	public static String getUniversityName() {
		return UNIVERSITY;
	}

	public static void displayUniversityInfo() {
		System.out.println("University: " + UNIVERSITY);
		System.out.println("Total Students: " + totalStudents);
	}

	// Compare two students by GPA
	public static Student getBetterStudent(Student s1, Student s2) {
		if (s1.gpa > s2.gpa) {
			return s1;
		} else if (s2.gpa > s1.gpa) {
			return s2;
		} else {
			return null; // Equal GPA
		}
	}
	
	
	

	// OVERRIDDEN METHODS
	// Override Object class methods
	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", studentId='" + studentId + '\'' + ", gpa="
				+ gpa + ", courses=" + courseCount + '}';
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }

}
