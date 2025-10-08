package AdvancedConcepts2;

public class Manager extends Employee {
	private double bonus;

	public Manager(String name, int id, double baseSalary, double bonus) {
		super(name, id, baseSalary); // Calling parent constructor
		this.bonus = bonus;
	}

	@Override
	double calculateSalary() {
		return baseSalary + bonus;
	}

	@Override
	void displayRole() {
		System.out.println("Role: Manager");
	}
}
