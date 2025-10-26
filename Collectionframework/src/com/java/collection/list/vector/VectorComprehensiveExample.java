package com.java.collection.list.vector;

import java.util.Vector;

public class VectorComprehensiveExample {
	public static void main(String[] args) {
		System.out.println("=== Comprehensive Vector Example ===\n");

		// Create a Vector of Student objects
		Vector<Student> students = new Vector<>();

		// Add students
		students.add(new Student("Alice", 85));
		students.add(new Student("Bob", 92));
		students.add(new Student("Charlie", 78));
		students.add(new Student("Diana", 95));
		students.add(new Student("Eve", 88));

		System.out.println("1. Original Students:");
		displayStudents(students);

		// Sort by grade
		students.sort((s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));
		System.out.println("\n2. Sorted by Grade (descending):");
		displayStudents(students);

		// Find student
		System.out.println("\n3. Search Operations:");
		int index = findStudent(students, "Charlie");
		if (index != -1) {
			System.out.println("   Found Charlie at index: " + index);
			System.out.println("   " + students.get(index));
		}

		// Filter students with grade > 85
		System.out.println("\n4. Students with grade > 85:");
		Vector<Student> topStudents = new Vector<>();
		students.forEach(student -> {
			if (student.getGrade() > 85) {
				topStudents.add(student);
			}
		});
		displayStudents(topStudents);

		// Calculate average grade
		System.out.println("\n5. Statistics:");
		double average = students.stream().mapToInt(Student::getGrade).average().orElse(0.0);
		System.out.println("   Average Grade: " + String.format("%.2f", average));
		System.out.println("   Total Students: " + students.size());
		System.out.println("   Capacity: " + students.capacity());

		// Clone and modify
		System.out.println("\n6. Cloning:");
		@SuppressWarnings("unchecked")
		Vector<Student> clonedStudents = (Vector<Student>) students.clone();
		clonedStudents.add(new Student("Frank", 91));
		System.out.println("   Original size: " + students.size());
		System.out.println("   Cloned size: " + clonedStudents.size());

		// Remove students with grade < 80
		System.out.println("\n7. Remove students with grade < 80:");
		students.removeIf(student -> student.getGrade() < 80);
		displayStudents(students);

		// SubList operations
		System.out.println("\n8. SubList (top 2 students):");
		if (students.size() >= 2) {
			System.out.println("   " + students.subList(0, 2));
		}
	}

	private static void displayStudents(Vector<Student> students) {
		students.forEach(student -> System.out.println("   " + student));
	}

	private static int findStudent(Vector<Student> students, String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}

class Student {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student{name='" + name + "', grade=" + grade + "}";
	}
}