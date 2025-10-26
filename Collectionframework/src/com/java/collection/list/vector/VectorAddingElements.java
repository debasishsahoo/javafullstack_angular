package com.java.collection.list.vector;

import java.util.Vector;

public class VectorAddingElements {
	public static void main(String[] args) {
		System.out.println("=== Adding Elements to Vector ===\n");

		Vector<String> vector = new Vector<>();

		// Method 1: add(E element) - adds to end
		System.out.println("1. add(E element):");
		vector.add("Java");
		vector.add("Python");
		vector.add("C++");
		System.out.println("   Vector: " + vector);

		// Method 2: add(int index, E element) - adds at specific position
		System.out.println("\n2. add(int index, E element):");
		vector.add(1, "JavaScript");
		System.out.println("   After adding 'JavaScript' at index 1: " + vector);

		// Method 3: addElement(E obj) - legacy method (same as add)
		System.out.println("\n3. addElement(E obj):");
		vector.addElement("Ruby");
		System.out.println("   After addElement('Ruby'): " + vector);

		// Method 4: addAll(Collection c) - adds all elements from collection
		System.out.println("\n4. addAll(Collection c):");
		Vector<String> moreLanguages = new Vector<>();
		moreLanguages.add("Go");
		moreLanguages.add("Rust");
		vector.addAll(moreLanguages);
		System.out.println("   After addAll: " + vector);

		// Method 5: addAll(int index, Collection c) - adds at specific position
		System.out.println("\n5. addAll(int index, Collection c):");
		Vector<String> scriptingLangs = new Vector<>();
		scriptingLangs.add("Perl");
		scriptingLangs.add("PHP");
		vector.addAll(2, scriptingLangs);
		System.out.println("   After addAll at index 2: " + vector);

		// Method 6: insertElementAt(E obj, int index)
		System.out.println("\n6. insertElementAt(E obj, int index):");
		vector.insertElementAt("Kotlin", 0);
		System.out.println("   After inserting 'Kotlin' at index 0: " + vector);
	}
}
