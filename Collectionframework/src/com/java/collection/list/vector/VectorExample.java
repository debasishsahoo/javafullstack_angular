package com.java.collection.list.vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		// Create a Vector of Strings
		Vector<String> vector = new Vector<>();

		// Add elements to Vector
		vector.add("Java");
		vector.add("Python");
		vector.add("C++");
		vector.add("Go");

		System.out.println("Initial Vector: " + vector);

		// Access elements by index
		System.out.println("First Element: " + vector.get(0));

		// Add element at specific index
		vector.add(2, "JavaScript");
		System.out.println("After Insertion: " + vector);

		// Remove an element
		vector.remove("C++");
		System.out.println("After Removal: " + vector);

		// Check if element exists
		System.out.println("Contains 'Python'? " + vector.contains("Python"));

		// Iterate using Enumeration (Legacy Style)
		System.out.println("\nIterating using Enumeration:");
		Enumeration<String> e = vector.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

		// Clone the Vector
		Vector<String> clonedVector = (Vector<String>) vector.clone();
		System.out.println("\nCloned Vector: " + clonedVector);

		// Size and Capacity
		System.out.println("Size: " + vector.size());
		System.out.println("Capacity: " + vector.capacity());

		// Clear all elements
		vector.clear();
		System.out.println("After Clearing: " + vector);
	}
}
