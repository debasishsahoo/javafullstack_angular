package AdvancedConcepts2;

public abstract class Employee {
	private String name;
	private int id;
	protected double baseSalary;

	// Constructor in abstract class
	public Employee(String name, int id, double baseSalary) {
		this.name = name;
		this.id = id;
		this.baseSalary = baseSalary;
		System.out.println("Employee constructor called");
	}

	// Parameterless constructor
	public Employee() {
		this.name = "Unknown";
		this.id = 0;
		this.baseSalary = 0.0;
	}

	// Abstract method
	abstract double calculateSalary();
	abstract void displayRole();

	// Concrete methods
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void displayInfo() {
		System.out.println("Name: " + name + ", ID: " + id);
	}

}
