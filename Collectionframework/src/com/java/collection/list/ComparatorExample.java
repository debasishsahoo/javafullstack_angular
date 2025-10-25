package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return name + " (" + marks + ")";
	}
}

public class ComparatorExample {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>(
				Arrays.asList(new Student("Alice", 85), 
						      new Student("Bob", 92), 
						      new Student("Charlie", 78)));

		// Sort by marks (ascending)
		students.sort(Comparator.comparingInt(s -> s.marks));
		System.out.println("Sorted by marks ascending: " + students);

		// Sort by marks (descending)
		students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed());
		System.out.println("Sorted by marks descending: " + students);

		// Sort by name (alphabetical)
		students.sort(Comparator.comparing(s -> s.name));
		System.out.println("Sorted by name: " + students);
	}

}
