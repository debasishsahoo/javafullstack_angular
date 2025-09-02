package call_one_constructor_from;

//How can you call one constructor from another using this()?
//this() must be the first statement in the constructor.
//It can only be used inside a constructor, not in methods.
public class Student {
	int id;
	String name;

	// 1. Default constructor
	Student() {
		this(0, "Unknown"); // calls the two-parameter constructor
	}

	// 2. Constructor with one parameter
	Student(int i) {
		this(i, "Unnamed"); // calls the two-parameter constructor

	}

	// 3. Constructor with two parameters
	Student(int i, String n) {
		id = i;
		name = n;
	}

	void display() {
		System.out.println(id + " " + name);
	}
}
