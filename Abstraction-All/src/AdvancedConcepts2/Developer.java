package AdvancedConcepts2;

public class Developer extends Employee {
	private int projectCount;

	public Developer(String name, int id, double baseSalary, int projectCount) {
		super(name, id, baseSalary);
		this.projectCount = projectCount;
	}

	@Override
	double calculateSalary() {
		return baseSalary + (projectCount * 500); // Bonus per project
	}

	@Override
	void displayRole() {
		System.out.println("Role: Developer");
	}
}
