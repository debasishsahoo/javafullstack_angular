package Compile_Time_Polymorphism;

//Constructor Overloading with Chaining
public class Employee {
	private String name;
	private int id;
	private double salary;
	private String department;

	// Default constructor
	public Employee() {
		this("Unknown", 0, 0.0, "General");
	}

	// Constructor with name only
	public Employee(String name) {
		this(name, 0, 0.0, "General");
	}

	// Constructor with name and id
	public Employee(String name, int id) {
		this(name, id, 0.0, "General");
	}

	// Constructor with name, id, and salary
	public Employee(String name, int id, double salary) {
		this(name, id, salary, "General");
	}

	// Master constructor
	public Employee(String name, int id, double salary, String department) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.department = department;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Optional: Override toString() for easy display
	@Override
	public String toString() {
		return "Employee [Name=" + name + ", ID=" + id + ", Salary=" + salary + ", Department=" + department + "]";
	}

	public static void main(String[] args) {
		// Create Employee objects using different constructors
		Employee emp1 = new Employee();
		Employee emp2 = new Employee("Alice");
		Employee emp3 = new Employee("Bob", 101);
		Employee emp4 = new Employee("Charlie", 102, 75000.0);
		Employee emp5 = new Employee("David", 103, 85000.0, "Engineering");

		// Display employees
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		System.out.println(emp4);
		System.out.println(emp5);

		// Modify using setter
		emp1.setName("Eve");
		emp1.setId(104);
		emp1.setSalary(50000.0);
		emp1.setDepartment("HR");

		System.out.println("After updating emp1:");
		System.out.println(emp1);

	}

}
