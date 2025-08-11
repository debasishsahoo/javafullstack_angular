
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
	
	// Multiple parameters
	public void updateGrade(int index, double newGrade) {
        if (index < 0 || index >= grades.length) {
            throw new IndexOutOfBoundsException("Invalid grade index: " + index);
        }
        validateGrade(newGrade);
        double oldGrade = grades[index];
        grades[index] = newGrade;
        System.out.println("Grade updated from " + oldGrade + " to " + newGrade);
    }
	
	
	// 7. STATIC METHODS
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static void resetStudentCounter() {
        totalStudents = 0;
        System.out.println("Student counter reset to 0");
    }
    
    // Static method with parameters
    public static Student createHonorStudent(String name, int age) {
        Student student = new Student(name, age);
        // Add high grades for honor student
        student.addGrade(95.0);
        student.addGrade(98.0);
        student.addGrade(92.0);
        System.out.println("Honor student created: " + name);
        return student;
    }
	
    
        // 8. OVERRIDDEN METHODS(Change the Default Nature)
        @Override
		public String toString() {
		    return String.format("Student[ID=%d, Name=%s, Age=%d, Average=%.2f]", 
		                       id, name, age, calculateAverage());
		}
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            
            if (obj == null || getClass() != obj.getClass()) return false;
            
            Student student = (Student) obj;
            return id == student.id;
        }
        
        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }
        
     // 9. METHOD RETURNING ARRAY
        public String[] getGradeReport() {
            String[] report = new String[grades.length + 2];
      
            report[0] = "Grade Report for: " + name;
            
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] > 0) {
                    report[i + 1] = "Grade " + (i + 1) + ": " + grades[i];
                } else {
                    report[i + 1] = "Grade " + (i + 1) + ": Not recorded";
                }
            }
            
            report[report.length - 1] = "Average: " + String.format("%.2f", calculateAverage());
            return report;
        }
	

}
