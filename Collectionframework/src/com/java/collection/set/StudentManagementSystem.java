package com.java.collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class StudentManagementSystem {
	public static void main(String[] args) {
		System.out.println("=== STUDENT MANAGEMENT SYSTEM ===\n");

		// Different sets for different purposes
		Set<StudentRecord> allStudents = new HashSet<>();
		Set<StudentRecord> honorsStudents = new TreeSet<>(Comparator.comparingDouble(StudentRecord::getGpa).reversed());
		Set<StudentRecord> attendanceOrder = new LinkedHashSet<>();

		// Adding students
		StudentRecord s1 = new StudentRecord("S001", "Alice Johnson", 3.8);
		StudentRecord s2 = new StudentRecord("S002", "Bob Smith", 3.9);
		StudentRecord s3 = new StudentRecord("S003", "Charlie Brown", 3.5);
		StudentRecord s4 = new StudentRecord("S004", "Diana Prince", 4.0);
		StudentRecord s5 = new StudentRecord("S005", "Eve Adams", 3.7);

		allStudents.add(s1);
		allStudents.add(s2);
		allStudents.add(s3);
		allStudents.add(s4);
		allStudents.add(s5);

		// Add to honors (GPA >= 3.7)
		for (StudentRecord student : allStudents) {
			if (student.getGpa() >= 3.7) {
				honorsStudents.add(student);
			}
		}

		// Add to attendance in registration order
		attendanceOrder.add(s3);
		attendanceOrder.add(s1);
		attendanceOrder.add(s5);
		attendanceOrder.add(s4);
		attendanceOrder.add(s2);

		// Display all students
		System.out.println("ALL STUDENTS (HashSet - no order):");
		for (StudentRecord student : allStudents) {
			System.out.println("  " + student);
		}
		System.out.println();

		// Display honors students
		System.out.println("HONORS STUDENTS (TreeSet - sorted by GPA):");
		for (StudentRecord student : honorsStudents) {
			System.out.println("  " + student);
		}
		System.out.println();

		// Display attendance order
		System.out.println("ATTENDANCE ORDER (LinkedHashSet - insertion order):");
		for (StudentRecord student : attendanceOrder) {
			System.out.println("  " + student);
		}
		System.out.println();

		// Find students in honors but not in attendance
		Set<StudentRecord> notInAttendance = new HashSet<>(honorsStudents);
		notInAttendance.removeAll(attendanceOrder);
		System.out.println("HONORS STUDENTS NOT IN ATTENDANCE:");
		for (StudentRecord student : notInAttendance) {
			System.out.println("  " + student);
		}
		System.out.println();

		// Check if student exists
		StudentRecord searchStudent = new StudentRecord("S003", "Charlie Brown", 3.5);
		System.out.println("Is Charlie Brown enrolled? " + allStudents.contains(searchStudent));

		// Statistics
		System.out.println("\nSTATISTICS:");
		System.out.println("Total Students: " + allStudents.size());
		System.out.println("Honors Students: " + honorsStudents.size());
		System.out.println("Present in Class: " + attendanceOrder.size());

		double avgGpa = allStudents.stream().mapToDouble(StudentRecord::getGpa).average().orElse(0.0);
		System.out.println("Average GPA: " + String.format("%.2f", avgGpa));
	}
}

class StudentRecord {
	private String id;
	private String name;
	private double gpa;

	public StudentRecord(String id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StudentRecord that = (StudentRecord) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.format("%s: %s (GPA: %.1f)", id, name, gpa);
	}
}
