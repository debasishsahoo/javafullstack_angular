package com.java.collection.list.vector;

import java.util.Collections;
import java.util.Vector;

public class VectorModificationOperations {
	public static void main(String[] args) {
		System.out.println("=== Vector Modification Operations ===\n");

		Vector<String> vector = new Vector<>();
		vector.add("Apple");
		vector.add("Banana");
		vector.add("Cherry");
		vector.add("Date");
		vector.add("Elderberry");

		System.out.println("Original Vector: " + vector);
		System.out.println();

		// Method 1: set(int index, E element)
		System.out.println("1. set(int index, E element):");
		String oldValue = vector.set(2, "Coconut");
		System.out.println("   Old value at index 2: " + oldValue);
		System.out.println("   Vector after set: " + vector);

		// Method 2: setElementAt(E obj, int index) - legacy method
		System.out.println("\n2. setElementAt(E obj, int index):");
		vector.setElementAt("Dragonfruit", 3);
		System.out.println("   Vector after setElementAt: " + vector);

		// Method 3: replaceAll(UnaryOperator operator)
		System.out.println("\n3. replaceAll(UnaryOperator operator):");
		Vector<String> v2 = new Vector<>();
		v2.add("java");
		v2.add("python");
		v2.add("c++");
		System.out.println("   Before: " + v2);
		v2.replaceAll(String::toUpperCase);
		System.out.println("   After replaceAll(toUpperCase): " + v2);

		// Method 4: sort(Comparator c)
		System.out.println("\n4. sort(Comparator c):");
		Vector<Integer> numbers = new Vector<>();
		numbers.add(5);
		numbers.add(2);
		numbers.add(8);
		numbers.add(1);
		numbers.add(9);
		System.out.println("   Before sorting: " + numbers);
		numbers.sort(null); // natural ordering
		System.out.println("   After sort(null): " + numbers);
		numbers.sort(Collections.reverseOrder());
		System.out.println("   After sort(reverseOrder): " + numbers);

		// Method 5: retainAll(Collection c)
		System.out.println("\n5. retainAll(Collection c):");
		Vector<String> v3 = new Vector<>();
		v3.add("A");
		v3.add("B");
		v3.add("C");
		v3.add("D");
		v3.add("E");
		Vector<String> retain = new Vector<>();
		retain.add("B");
		retain.add("D");
		retain.add("F");
		System.out.println("   Before: " + v3);
		v3.retainAll(retain);
		System.out.println("   After retainAll(['B', 'D', 'F']): " + v3);
	}
}
