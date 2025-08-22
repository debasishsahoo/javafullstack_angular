package AlternativeCreation.FactoryMethods;

public class Student {
	private String name;
	private int age;

	// Private constructor - forces use of factory methods
	private Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Factory method with validation
	public static Student createStudent(String name, int age) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		if (age < 0 || age > 120) {
			throw new IllegalArgumentException("Invalid age");
		}
		return new Student(name, age);
	}

	// Factory method for minor students
	public static Student createMinorStudent(String name) {
		return new Student(name, 16);
	}

	// Factory method for adult students
	public static Student createAdultStudent(String name) {
		return new Student(name, 18);
	}

	
	
	public static void main(String[] args) {
		Student student1 = Student.createStudent("John", 20);
		Student student2 = Student.createMinorStudent("Jane");
		Student student3 = Student.createAdultStudent("Deb");
	}

}
