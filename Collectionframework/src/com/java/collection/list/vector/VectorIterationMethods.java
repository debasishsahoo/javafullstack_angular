package com.java.collection.list.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorIterationMethods {
	public static void main(String[] args) {
		System.out.println("=== Vector Iteration Methods ===\n");

		Vector<String> vector = new Vector<>();
		vector.add("Alpha");
		vector.add("Beta");
		vector.add("Gamma");
		vector.add("Delta");
		vector.add("Epsilon");

		System.out.println("Vector: " + vector);
		System.out.println();

		// Method 1: Enhanced for loop (forEach)
		System.out.println("1. Enhanced for loop:");
		System.out.print("   ");
		for (String element : vector) {
			System.out.print(element + " ");
		}
		System.out.println();

		// Method 2: forEach(Consumer action) - Java 8
		System.out.println("\n2. forEach(Consumer action):");
		System.out.print("   ");
		vector.forEach(element -> System.out.print(element + " "));
		System.out.println();

		// Method 3: iterator()
		System.out.println("\n3. iterator():");
		Iterator<String> iterator = vector.iterator();
		System.out.print("   ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		// Method 4: listIterator()
		System.out.println("\n4. listIterator():");
		ListIterator<String> listIterator = vector.listIterator();
		System.out.print("   Forward: ");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.print("\n   Backward: ");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
		System.out.println();

		// Method 5: listIterator(int index)
		System.out.println("\n5. listIterator(int index):");
		ListIterator<String> listIterator2 = vector.listIterator(2);
		System.out.print("   From index 2: ");
		while (listIterator2.hasNext()) {
			System.out.print(listIterator2.next() + " ");
		}
		System.out.println();

		// Method 6: elements() - returns Enumeration (legacy)
		System.out.println("\n6. elements() - Enumeration:");
		Enumeration<String> enumeration = vector.elements();
		System.out.print("   ");
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		System.out.println();

		// Method 7: stream() - Java 8
		System.out.println("\n7. stream():");
		System.out.print("   Filtered (length > 4): ");
		vector.stream().filter(s -> s.length() > 4).forEach(s -> System.out.print(s + " "));
		System.out.println();

		// Method 8: parallelStream() - Java 8
		System.out.println("\n8. parallelStream():");
		System.out.print("   Uppercase: ");
		vector.parallelStream().map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
}
