package com.java.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetDemo {
	public static void main(String[] args) {
		System.out.println("=== HASHSET DEMONSTRATION ===\n");

		// 1. Creating HashSet with different constructors
		System.out.println("1. HashSet Constructors:");

		// Default constructor (initial capacity 16, load factor 0.75)
		Set<String> hashSet1 = new HashSet<>();

		// Constructor with initial capacity
		Set<String> hashSet2 = new HashSet<>(32);

		// Constructor with initial capacity and load factor
		Set<String> hashSet3 = new HashSet<>(32, 0.80f);

		// Constructor with collection
		List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B");
		Set<String> hashSet4 = new HashSet<>(list);
		System.out.println("HashSet from List (duplicates removed): " + hashSet4);
		System.out.println();

		// 2. Adding elements
		System.out.println("2. Adding Elements:");
		Set<Integer> numbers = new HashSet<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(20); // Duplicate - won't be added
		System.out.println("Numbers Set: " + numbers);
		System.out.println();

		// 3. HashSet allows null
		System.out.println("3. Null Element:");
		Set<String> setWithNull = new HashSet<>();
		setWithNull.add("First");
		setWithNull.add(null);
		setWithNull.add("Second");
		setWithNull.add(null); // Only one null allowed
		System.out.println("Set with null: " + setWithNull);
		System.out.println();

		// 4. Iteration order is unpredictable
		System.out.println("4. Unpredictable Iteration Order:");
		Set<Integer> orderTest = new HashSet<>();
		for (int i = 1; i <= 10; i++) {
			orderTest.add(i);
		}
		System.out.println("Added 1-10 in order: " + orderTest);
		System.out.println();

		// 5. Performance characteristics
		System.out.println("5. Performance Test:");
		Set<Integer> perfSet = new HashSet<>();
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			perfSet.add(i);
		}
		long endTime = System.nanoTime();
		System.out.println("Time to add 100,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

		startTime = System.nanoTime();
		boolean found = perfSet.contains(50000);
		endTime = System.nanoTime();
		System.out.println("Time to search element: " + (endTime - startTime) + " nanoseconds");
		System.out.println();

		// 6. Custom objects in HashSet
		System.out.println("6. Custom Objects:");
		Set<Person> people = new HashSet<>();
		people.add(new Person("John", 25));
		people.add(new Person("Jane", 30));
		people.add(new Person("John", 25)); // Duplicate based on equals/hashCode
		System.out.println("People Set: " + people);
		System.out.println("Size: " + people.size());
	}
}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return age == person.age && Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "}";
	}
}
