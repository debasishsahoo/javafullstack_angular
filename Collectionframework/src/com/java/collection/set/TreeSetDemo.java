package com.java.collection.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		System.out.println("=== TREESET DEMONSTRATION ===\n");

		// 1. Natural ordering (sorted)
		System.out.println("1. Natural Ordering:");
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(50);
		treeSet.add(20);
		treeSet.add(80);
		treeSet.add(10);
		treeSet.add(40);
		System.out.println("TreeSet (automatically sorted): " + treeSet);
		System.out.println();

		// 2. String natural ordering
		System.out.println("2. String Natural Ordering:");
		Set<String> words = new TreeSet<>();
		words.add("Zebra");
		words.add("Apple");
		words.add("Mango");
		words.add("Banana");
		System.out.println("Sorted Strings: " + words);
		System.out.println();

		// 3. Custom comparator
		System.out.println("3. Custom Comparator (Reverse Order):");
		Set<Integer> reverseSet = new TreeSet<>(Collections.reverseOrder());
		reverseSet.add(50);
		reverseSet.add(20);
		reverseSet.add(80);
		reverseSet.add(10);
		System.out.println("Reverse order: " + reverseSet);
		System.out.println();

		// 4. Custom comparator for strings (by length)
		System.out.println("4. Custom Comparator (String Length):");
		Set<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
		byLength.add("Apple");
		byLength.add("Banana");
		byLength.add("Fig");
		byLength.add("Kiwi");
		byLength.add("Grape");
		System.out.println("Sorted by length: " + byLength);
		System.out.println();

		// 5. NavigableSet methods
		System.out.println("5. NavigableSet Methods:");
		NavigableSet<Integer> navSet = new TreeSet<>();
		navSet.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));

		System.out.println("Full set: " + navSet);
		System.out.println("first(): " + navSet.first());
		System.out.println("last(): " + navSet.last());
		System.out.println("lower(50): " + navSet.lower(50));
		System.out.println("floor(50): " + navSet.floor(50));
		System.out.println("ceiling(55): " + navSet.ceiling(55));
		System.out.println("higher(50): " + navSet.higher(50));
		System.out.println();

		// 6. Subset operations
		System.out.println("6. Subset Operations:");
		System.out.println("headSet(50): " + navSet.headSet(50));
		System.out.println("tailSet(50): " + navSet.tailSet(50));
		System.out.println("subSet(30, 70): " + navSet.subSet(30, 70));
		System.out.println();

		// 7. Polling operations
		System.out.println("7. Polling Operations:");
		NavigableSet<Integer> pollSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("Before polling: " + pollSet);
		System.out.println("pollFirst(): " + pollSet.pollFirst());
		System.out.println("pollLast(): " + pollSet.pollLast());
		System.out.println("After polling: " + pollSet);
		System.out.println();

		// 8. Descending set
		System.out.println("8. Descending Set:");
		NavigableSet<Integer> descSet = navSet.descendingSet();
		System.out.println("Original: " + navSet);
		System.out.println("Descending: " + descSet);
		System.out.println();

		// 9. Custom objects with Comparable
		System.out.println("9. Custom Objects with Comparable:");
		Set<Student> students = new TreeSet<>();
		students.add(new Student("Alice", 85));
		students.add(new Student("Bob", 92));
		students.add(new Student("Charlie", 78));
		students.add(new Student("David", 95));
		System.out.println("Students sorted by score:");
		for (Student student : students) {
			System.out.println("  " + student);
		}
		System.out.println();

		// 10. TreeSet does not allow null
		System.out.println("10. Null Element Test:");
		try {
			TreeSet<String> nullTest = new TreeSet<>();
			nullTest.add("First");
			nullTest.add(null); // Will throw NullPointerException
		} catch (NullPointerException e) {
			System.out.println("NullPointerException: TreeSet doesn't allow null");
		}
	}
}

class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student other) {
		return Integer.compare(this.score, other.score);
	}

	@Override
	public String toString() {
		return name + " (Score: " + score + ")";
	}
}
