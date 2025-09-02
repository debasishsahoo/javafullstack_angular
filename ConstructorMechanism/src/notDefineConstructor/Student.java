package notDefineConstructor;

//What happens if you don’t define a constructor in a class?
//implicit default constructor->provided by JVM
// .Takes no parameters
// .Has no body(performs no custom initialization)
// .Calls the parent class's default constructor (if the class extends another class)
// .Initializes instance variables to their default values:
//- Numbers: 0
//- Booleans: false
//- Object references: null
//- Characters: '\0'
public class Student {
	String name; // // Will be null
	int age; // // Will be 0
	boolean enrolled; // Will be false

	// No constructor defined - compiler adds implicit default constructor

	// public Student() { //Add by JVM
	// Empty - just calls super() implicitly
	// }
	
	
	
	

	public static void main(String[] args) {
		Student student = new Student();

		System.out.println(student.name); // null
		System.out.println(student.age); // 0
		System.out.println(student.enrolled); // false

	}

}
