package com.java.collection.set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int compareTo(Student s) {
		return this.id - s.id; // Sort by id
	}

	public String toString() {
		return id + " - " + name;
	}
}

public class TreeSetCustom {

	public static void main(String[] args) {
		TreeSet<Student> students = new TreeSet<>(Comparator.comparing(s -> s.name));
		students.add(new Student(3, "Alice"));
		students.add(new Student(1, "Bob"));
		students.add(new Student(2, "Charlie"));

		for (Student s : students)
			System.out.println(s);

	}

}
