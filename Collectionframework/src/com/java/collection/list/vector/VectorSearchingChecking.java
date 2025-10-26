package com.java.collection.list.vector;

import java.util.Vector;

public class VectorSearchingChecking {
	public static void main(String[] args) {
		System.out.println("=== Searching and Checking in Vector ===\n");

		Vector<String> vector = new Vector<>();
		vector.add("Java");
		vector.add("Python");
		vector.add("JavaScript");
		vector.add("Python"); // duplicate
		vector.add("C++");

		System.out.println("Vector: " + vector);
		System.out.println();

		// Method 1: contains(Object o)
		System.out.println("1. contains(Object o):");
		System.out.println("   Contains 'Python': " + vector.contains("Python"));
		System.out.println("   Contains 'Ruby': " + vector.contains("Ruby"));

		// Method 2: containsAll(Collection c)
		System.out.println("\n2. containsAll(Collection c):");
		Vector<String> subset = new Vector<>();
		subset.add("Java");
		subset.add("C++");
		System.out.println("   Contains all ['Java', 'C++']: " + vector.containsAll(subset));

		// Method 3: indexOf(Object o) - first occurrence
		System.out.println("\n3. indexOf(Object o):");
		System.out.println("   Index of 'Python': " + vector.indexOf("Python"));
		System.out.println("   Index of 'Ruby': " + vector.indexOf("Ruby"));

		// Method 4: indexOf(Object o, int index) - from specific index
		System.out.println("\n4. indexOf(Object o, int index):");
		System.out.println("   Index of 'Python' from index 2: " + vector.indexOf("Python", 2));

		// Method 5: lastIndexOf(Object o) - last occurrence
		System.out.println("\n5. lastIndexOf(Object o):");
		System.out.println("   Last index of 'Python': " + vector.lastIndexOf("Python"));

		// Method 6: lastIndexOf(Object o, int index) - backwards from index
		System.out.println("\n6. lastIndexOf(Object o, int index):");
		System.out.println("   Last index of 'Python' from index 2: " + vector.lastIndexOf("Python", 2));

		// Method 7: isEmpty()
		System.out.println("\n7. isEmpty():");
		System.out.println("   Vector is empty: " + vector.isEmpty());
		Vector<String> emptyVector = new Vector<>();
		System.out.println("   Empty vector is empty: " + emptyVector.isEmpty());

		// Method 8: size()
		System.out.println("\n8. size():");
		System.out.println("   Size of vector: " + vector.size());
	}
}
