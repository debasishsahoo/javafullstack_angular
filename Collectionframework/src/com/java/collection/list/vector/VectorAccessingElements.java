package com.java.collection.list.vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorAccessingElements {
	public static void main(String[] args) {
		System.out.println("=== Accessing Elements from Vector ===\n");

		Vector<String> vector = new Vector<>();
		vector.add("First");
		vector.add("Second");
		vector.add("Third");
		vector.add("Fourth");
		vector.add("Fifth");

		System.out.println("Original Vector: " + vector);
		System.out.println();

		// Method 1: get(int index)
		System.out.println("1. get(int index):");
		System.out.println("   Element at index 2: " + vector.get(2));

		// Method 2: elementAt(int index) - legacy method
		System.out.println("\n2. elementAt(int index):");
		System.out.println("   Element at index 3: " + vector.elementAt(3));

		// Method 3: firstElement()
		System.out.println("\n3. firstElement():");
		System.out.println("   First element: " + vector.firstElement());

		// Method 4: lastElement()
		System.out.println("\n4. lastElement():");
		System.out.println("   Last element: " + vector.lastElement());

		// Method 5: elements() - returns Enumeration
		System.out.println("\n5. elements() - returns Enumeration:");
		Enumeration<String> enumeration = vector.elements();
		System.out.print("   Elements: ");
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		System.out.println();

		// Method 6: toArray()
		System.out.println("\n6. toArray():");
		Object[] array = vector.toArray();
		System.out.print("   Array: ");
		for (Object obj : array) {
			System.out.print(obj + " ");
		}
		System.out.println();

		// Method 7: toArray(T[] a)
		System.out.println("\n7. toArray(T[] a):");
		String[] stringArray = new String[vector.size()];
		vector.toArray(stringArray);
		System.out.print("   String Array: ");
		for (String s : stringArray) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
