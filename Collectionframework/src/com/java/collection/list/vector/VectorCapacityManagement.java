package com.java.collection.list.vector;

import java.util.Vector;

public class VectorCapacityManagement {
	public static void main(String[] args) {
		System.out.println("=== Vector Capacity Management ===\n");

		// Method 1: capacity()
		System.out.println("1. capacity():");
		Vector<Integer> vector = new Vector<>();
		System.out.println("   Initial capacity: " + vector.capacity());
		System.out.println("   Initial size: " + vector.size());

		// Add elements to show capacity growth
		for (int i = 0; i < 11; i++) {
			vector.add(i);
			System.out.println(
					"   After adding element " + i + ": size=" + vector.size() + ", capacity=" + vector.capacity());
		}

		// Method 2: ensureCapacity(int minCapacity)
		System.out.println("\n2. ensureCapacity(int minCapacity):");
		Vector<String> v2 = new Vector<>();
		System.out.println("   Before ensureCapacity(50):");
		System.out.println("   Capacity: " + v2.capacity());
		v2.ensureCapacity(50);
		System.out.println("   After ensureCapacity(50):");
		System.out.println("   Capacity: " + v2.capacity());

		// Method 3: setSize(int newSize)
		System.out.println("\n3. setSize(int newSize):");
		Vector<String> v3 = new Vector<>();
		v3.add("A");
		v3.add("B");
		v3.add("C");
		System.out.println("   Before: " + v3 + ", size=" + v3.size());
		v3.setSize(5); // increase size
		System.out.println("   After setSize(5): " + v3 + ", size=" + v3.size());
		v3.setSize(2); // decrease size
		System.out.println("   After setSize(2): " + v3 + ", size=" + v3.size());

		// Method 4: trimToSize()
		System.out.println("\n4. trimToSize():");
		Vector<String> v4 = new Vector<>(100);
		v4.add("One");
		v4.add("Two");
		v4.add("Three");
		System.out.println("   Before trimToSize():");
		System.out.println("   Size: " + v4.size() + ", Capacity: " + v4.capacity());
		v4.trimToSize();
		System.out.println("   After trimToSize():");
		System.out.println("   Size: " + v4.size() + ", Capacity: " + v4.capacity());
	}
}
