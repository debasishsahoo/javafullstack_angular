package com.java.collection.set.hashset;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // CRITICAL: Must override both hashCode() and equals()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id &&
               Objects.equals(name, employee.name) &&
               Objects.equals(department, employee.department);
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s'}",
            id, name, department);
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
}

public class CustomObjectHashSetDemo {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();

        // Add employees
        Employee e1 = new Employee(101, "Alice", "Engineering");
        Employee e2 = new Employee(102, "Bob", "Marketing");
        Employee e3 = new Employee(103, "Charlie", "Engineering");
        Employee e4 = new Employee(101, "Alice", "Engineering"); // Duplicate of e1

        System.out.println("Adding employees:");
        System.out.println("add(e1): " + employees.add(e1));
        System.out.println("add(e2): " + employees.add(e2));
        System.out.println("add(e3): " + employees.add(e3));
        System.out.println("add(e4 - duplicate): " + employees.add(e4));

        System.out.println("\nTotal unique employees: " + employees.size());
        System.out.println("\nEmployee list:");
        employees.forEach(System.out::println);

        // Search for employee
        Employee searchEmp = new Employee(102, "Bob", "Marketing");
        System.out.println("\nSearching for: " + searchEmp);
        System.out.println("Found: " + employees.contains(searchEmp));

        // Remove employee
        System.out.println("\nRemoving employee with id 102");
        employees.removeIf(emp -> emp.getId() == 102);
        System.out.println("Remaining employees: " + employees.size());

        // Group by department
        System.out.println("\nGrouping by department:");
        Map<String, Long> deptCount = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
            ));
        deptCount.forEach((dept, count) ->
            System.out.println("  " + dept + ": " + count + " employees"));
    }
}

