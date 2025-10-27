package com.java.Hash;

import java.util.HashSet;
import java.util.Objects;

public class Student {
	private String name;
	private int rollNumber;
	private double gpa;

	// Constructor
	public Student(String name, int rollNumber, double gpa) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.gpa = gpa;
	}

	// Overriding hashCode() using Effective Java approach

	@Override
	public int hashCode() {
		int result = 17; // Start with a non-zero constant (prime)

		// Multiply by 31 and add each significant field
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + rollNumber;

		// For double, use long bits to avoid floating point issues
		long gpaLongBits = Double.doubleToLongBits(gpa);
		result = 31 * result + (int) (gpaLongBits ^ (gpaLongBits >>> 32));

		return result;
	}

	// Overriding equals() for logical equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // same object
		if (obj == null || getClass() != obj.getClass())
			return false; // type check

		Student student = (Student) obj;
		return rollNumber == student.rollNumber && Double.compare(student.gpa, gpa) == 0
				&& Objects.equals(name, student.name);
	}

	// toString() for readable output
	@Override
	public String toString() {
		return "Student{name='" + name + "', rollNumber=" + rollNumber + ", gpa=" + gpa + "}";
	}

	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<>();

		Student s1 = new Student("Alice", 101, 3.8);
		Student s2 = new Student("Bob", 102, 3.5);
		Student s3 = new Student("Alice", 101, 3.8); // logically same as s1

		students.add(s1);
		students.add(s2);
		students.add(s3); // should not add duplicate (s1 == s3 logically)

		System.out.println("Students in HashSet:");
		for (Student s : students) {
			System.out.println(s);
		}

		System.out.println("\nComparisons:");
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		System.out.println("s1.hashCode(): " + s1.hashCode());
		System.out.println("s3.hashCode(): " + s3.hashCode());
	}

}
