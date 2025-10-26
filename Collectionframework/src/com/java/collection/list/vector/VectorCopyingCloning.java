package com.java.collection.list.vector;

import java.util.Vector;

public class VectorCopyingCloning {
	public static void main(String[] args) {
		System.out.println("=== Vector Copying and Cloning ===\n");

		Vector<String> original = new Vector<>();
		original.add("Red");
		original.add("Green");
		original.add("Blue");

		System.out.println("Original Vector: " + original);
		System.out.println();

		// Method 1: clone()
		System.out.println("1. clone():");
		@SuppressWarnings("unchecked")
		Vector<String> cloned = (Vector<String>) original.clone();
		System.out.println("   Cloned Vector: " + cloned);

		// Modify cloned to show it's a separate copy
		cloned.add("Yellow");
		System.out.println("   After adding 'Yellow' to cloned:");
		System.out.println("   Original: " + original);
		System.out.println("   Cloned: " + cloned);

		// Method 2: copyInto(Object[] anArray)
		System.out.println("\n2. copyInto(Object[] anArray):");
		Vector<Integer> numbers = new Vector<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);

		Object[] array = new Object[6];
		array[0] = "Start";
		numbers.copyInto(array);
		System.out.print("   Array after copyInto: ");
		for (Object obj : array) {
			System.out.print(obj + " ");
		}
		System.out.println();

		// Method 3: subList(int fromIndex, int toIndex)
		System.out.println("\n3. subList(int fromIndex, int toIndex):");
		Vector<String> colors = new Vector<>();
		colors.add("Red");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Indigo");
		colors.add("Violet");

		System.out.println("   Original: " + colors);
		System.out.println("   SubList(2, 5): " + colors.subList(2, 5));

		// Note: subList is a view, modifications affect original
		colors.subList(2, 5).clear();
		System.out.println("   After clearing subList(2, 5): " + colors);
	}
}
