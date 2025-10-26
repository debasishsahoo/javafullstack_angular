package com.java.collection.list.vector;

import java.util.Vector;

public class VectorRemovingElements {
	public static void main(String[] args) {
		System.out.println("=== Removing Elements from Vector ===\n");

		Vector<String> vector = new Vector<>();
		vector.add("Apple");
		vector.add("Banana");
		vector.add("Cherry");
		vector.add("Date");
		vector.add("Elderberry");
		vector.add("Banana"); // duplicate

		System.out.println("Original Vector: " + vector);
		System.out.println();

		// Method 1: remove(int index)
		System.out.println("1. remove(int index):");
		String removed = vector.remove(2);
		System.out.println("   Removed element at index 2: " + removed);
		System.out.println("   Vector: " + vector);

		// Method 2: remove(Object o) - removes first occurrence
		System.out.println("\n2. remove(Object o):");
		boolean isRemoved = vector.remove("Banana");
		System.out.println("   Removed 'Banana': " + isRemoved);
		System.out.println("   Vector: " + vector);

		// Method 3: removeElement(Object obj) - legacy method
		System.out.println("\n3. removeElement(Object obj):");
		boolean removed2 = vector.removeElement("Date");
		System.out.println("   Removed 'Date': " + removed2);
		System.out.println("   Vector: " + vector);

		// Method 4: removeElementAt(int index)
		System.out.println("\n4. removeElementAt(int index):");
		vector.removeElementAt(0);
		System.out.println("   After removing element at index 0: " + vector);

		// Repopulate for more examples
		vector.clear();
		vector.add("A");
		vector.add("B");
		vector.add("C");
		vector.add("D");
		vector.add("E");
		System.out.println("\nRepopulated Vector: " + vector);

		// Method 5: removeAll(Collection c)
		System.out.println("\n5. removeAll(Collection c):");
		Vector<String> toRemove = new Vector<>();
		toRemove.add("B");
		toRemove.add("D");
		vector.removeAll(toRemove);
		System.out.println("   After removeAll(['B', 'D']): " + vector);

		// Method 6: removeAllElements() - removes all elements
		System.out.println("\n6. removeAllElements():");
		Vector<String> temp = new Vector<>();
		temp.add("X");
		temp.add("Y");
		temp.add("Z");
		System.out.println("   Before: " + temp);
		temp.removeAllElements();
		System.out.println("   After removeAllElements(): " + temp);

		// Method 7: clear() - removes all elements
		System.out.println("\n7. clear():");
		vector.add("Test1");
		vector.add("Test2");
		System.out.println("   Before: " + vector);
		vector.clear();
		System.out.println("   After clear(): " + vector);

		// Method 8: removeIf(Predicate) - removes elements matching condition
		System.out.println("\n8. removeIf(Predicate):");
		vector.add("Apple");
		vector.add("Avocado");
		vector.add("Banana");
		vector.add("Apricot");
		System.out.println("   Before: " + vector);
		vector.removeIf(s -> s.startsWith("A"));
		System.out.println("   After removing elements starting with 'A': " + vector);

		// Method 9: removeRange(int fromIndex, int toIndex) - protected method
		// Note: This is a protected method, typically used in subclasses
		System.out.println("\n9. removeRange(int fromIndex, int toIndex):");
		System.out.println("   (Protected method - used in subclasses)");
	}
}
