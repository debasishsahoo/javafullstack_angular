package constructorchaining;

class Person {
	protected String name;

	public Person(String name) {
		this.name = name;
		System.out.println("Person constructor: " + name);
	}
}

class Employee extends Person {
	private int id;
	private String department;

	// Constructor with name and id
	public Employee(String name, int id) {
		super(name); // Calls Person(String) constructor
		this.id = id;
		System.out.println("Employee constructor: ID " + id);
	}

	// Constructor with name, id, and department
	public Employee(String name, int id, String department) {
		this(name, id); // Calls Employee(String, int) -> which calls super(name)
		this.department = department;
		System.out.println("Employee department set: " + department);
	}

}

public class Combining_this_and_super {

	public static void main(String[] args) {
		System.out.println("=== Creating Employee with 2 parameters ===");
		Employee e1 = new Employee("Alice", 101);

		System.out.println("\n=== Creating Employee with 3 parameters ===");
		Employee e2 = new Employee("Bob", 102, "HR");

	}

}


//- `super(...)` → calls the **parent class constructor**.
//- `this(...)` → calls another **constructor in the same class**.
//- Both must be the **first statement** in a constructor.
//- In the 3-arg constructor, `this(name, id)` ensures we don’t repeat code for initializing `name` and `id`




