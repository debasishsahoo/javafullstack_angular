package com.java.Hash;

import java.util.HashSet;

public class Person {
	private String name;
	private int age;

	// Constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Overriding hashCode()
	@Override
	public int hashCode() {
		// Simple hash code formula (can be improved with Objects.hash)
		return name.hashCode() + age;
	}

	// Overriding equals()
	@Override
	public boolean equals(Object obj) {
		// If both references point to the same object
		if (this == obj)
			return true;

		// If obj is null or of a different class
		if (obj == null || getClass() != obj.getClass())
			return false;

		// Typecast and compare fields
		Person person = (Person) obj;
		return age == person.age && name.equals(person.name);
	}

	// For printing object data
	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "}";
	}

	public static void main(String[] args) {
		HashSet<Person> people = new HashSet<>();

		Person p1 = new Person("Alice", 25);
		Person p2 = new Person("Bob", 30);
		Person p3 = new Person("Alice", 25); // Same as p1

		// Adding to HashSet
		people.add(p1);
		people.add(p2);
		people.add(p3); // Should not add (duplicate based on equals & hashCode)

		// Displaying the set
		System.out.println("HashSet contains:");
		for (Person p : people) {
			System.out.println(p);
		}

		// Checking equality manually
		System.out.println("\np1.equals(p3): " + p1.equals(p3));
		System.out.println("p1.hashCode(): " + p1.hashCode());
		System.out.println("p3.hashCode(): " + p3.hashCode());

	}

}
