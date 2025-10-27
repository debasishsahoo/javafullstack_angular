package com.java.Hash;

import java.util.HashSet;
import java.util.Objects;

public class Employee extends Object {
	private String name;
	private int id;
	private String department;

	// Constructor
	public Employee(String name, int id, String department) {
		this.name = name;
		this.id = id;
		this.department = department;
	}

	// Overriding hashCode() using Objects.hash() (recommended)
	@Override
	public int hashCode() {
		return Objects.hash(name, id, department);
	}

	// Overriding equals() using Objects.equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // same reference
		if (obj == null || getClass() != obj.getClass())
			return false; // type check

		Employee employee = (Employee) obj;
		return id == employee.id && Objects.equals(name, employee.name)
				&& Objects.equals(department, employee.department);
	}

	// toString() for readable output
	@Override
	public String toString() {
		return "Employee{name='" + name + "', id=" + id + ", department='" + department + "'}";
	}

	public static void main(String[] args) {
		HashSet<Employee> employees = new HashSet<>();

        Employee e1 = new Employee("Alice", 101, "HR");
        Employee e2 = new Employee("Bob", 102, "IT");
        Employee e3 = new Employee("Alice", 101, "HR"); // Duplicate logically

        employees.add(e1);
        employees.add(e2);
        employees.add(e3); // Should not be added (same as e1)

        System.out.println("Employee HashSet contains:");
        for (Employee e : employees) {
            System.out.println(e);
        }
        
        System.out.println("\nComparisons:");
        System.out.println("e1.equals(e3): " + e1.equals(e3));
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e3.hashCode(): " + e3.hashCode());
	}

}
