
public class Student {
	private String name;
	private int age;

	// Constructor with parameter names same as instance variables
	public Student(String name, int age) {
		this.name = name; // this.name refers to instance variable
		this.age = age; // this.age refers to instance variable
	}

	// Setter method with name conflict
	public void setName(String name) {
		this.name = name; // Without 'this', it would be name = name (no effect)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
