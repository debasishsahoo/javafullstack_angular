
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

	// 5. INSTANCE METHODS WITH DIFFERENT RETURN TYPES

	// Void method (Return Nothing)
	public void displayInfo() {
		System.out.println("=== Student Information ===");
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Average Grade: " + calculateAverage());
		System.out.println("Grade: " + getLetterGrade());
		System.out.println("========================");
	}

	// Method returning primitive type
	public double calculateAverage() {
		if (grades == null || grades.length == 0)
			return 0.0;
		double sum = 0;
		int count = 0;
		for (double grade : grades) {
			if (grade > 0) {
				sum += grade;
				count++;
			}
		}
		return count > 0 ? sum / count : 0.0;
	}

	// Method returning boolean
	public boolean isPassing() {
		return calculateAverage() >= 60.0;
	}

	// Method returning String
	public String getLetterGrade() {
		double avg = calculateAverage();
		if (avg >= 90)
			return "A";
		else if (avg >= 80)
			return "B";
		else if (avg >= 70)
			return "C";
		else if (avg >= 60)
			return "D";
		else
			return "F";
	}

	// 6. METHOD WITH PARAMETERS
	   // Single parameter
	public void addGrade(double grade) {
        validateGrade(grade);
        
        // Find first empty slot
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == 0) {
                grades[i] = grade;
                System.out.println("Grade " + grade + " added for " + name);
                return;
            }
        }
        System.out.println("Cannot add grade - all slots filled");
    }
	
	private void validateGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Student stuObj1 = new Student(); // Instance One- stuObj1

		Student stuObj2 = new Student("Deb", 34); // Instance Two-stuObj2

	}

}
