package com.java.collection.list.arraylist;

import java.util.ArrayList;

public class ArrayListCapacity {
	public static void main(String[] args) {
		System.out.println("=== CAPACITY & PERFORMANCE ===\n");

		// CAPACITY MANAGEMENT
		System.out.println("--- Capacity Management ---");

		// Creating with specific capacity
		ArrayList<String> list = new ArrayList<>(5);
		System.out.println("Created with capacity 5");
		System.out.println("Initial size: " + list.size());

		list.add("A");
		list.add("B");
		list.add("C");
		System.out.println("\nAfter adding 3 elements:");
		System.out.println("Size: " + list.size());

		// ensureCapacity - increases capacity if needed
		list.ensureCapacity(100);
		System.out.println("\nAfter ensureCapacity(100):");
		System.out.println("Size remains: " + list.size());

		// trimToSize - reduces capacity to current size
		ArrayList<Integer> nums = new ArrayList<>(100);
		for (int i = 0; i < 10; i++) {
			nums.add(i);
		}
		System.out.println("\nCreated with capacity 100, added 10 elements");
		System.out.println("Size: " + nums.size());
		nums.trimToSize();
		System.out.println("After trimToSize() - capacity now matches size");

		// AUTOMATIC GROWTH
		System.out.println("\n--- Automatic Growth ---");
		ArrayList<Integer> growing = new ArrayList<>(2);
		System.out.println("Initial capacity: 2\n");

		for (int i = 0; i < 10; i++) {
			growing.add(i);
			System.out.println("Added " + i + ", size: " + growing.size());
		}

		// PERFORMANCE COMPARISONS
		System.out.println("\n--- Performance Tests ---");

		int size = 100000;

		// 1. Pre-sizing benefit
		System.out.println("\n1. Pre-sizing Test:");

		long start = System.nanoTime();
		ArrayList<Integer> noPre = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			noPre.add(i);
		}
		long timeNoPre = System.nanoTime() - start;

		start = System.nanoTime();
		ArrayList<Integer> withPre = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			withPre.add(i);
		}
		long timePre = System.nanoTime() - start;

		System.out.println("   Without pre-sizing: " + timeNoPre + " ns");
		System.out.println("   With pre-sizing: " + timePre + " ns");
		System.out.println("   Improvement: " + ((timeNoPre - timePre) * 100 / timeNoPre) + "%");

		// 2. Adding at end vs beginning
		System.out.println("\n2. Add Position Test:");

		ArrayList<Integer> list1 = new ArrayList<>();
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			list1.add(i); // O(1) amortized
		}
		long endAdd = System.nanoTime() - start;

		ArrayList<Integer> list2 = new ArrayList<>();
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, i); // O(n) - shifts elements
		}
		long beginAdd = System.nanoTime() - start;

		System.out.println("   Add at end (100k): " + endAdd + " ns");
		System.out.println("   Add at beginning (10k): " + beginAdd + " ns");

		// 3. get() vs iterator
		System.out.println("\n3. Access Method Test:");

		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			data.add(i);
		}

		start = System.nanoTime();
		for (int i = 0; i < data.size(); i++) {
			int val = data.get(i);
		}
		long getTime = System.nanoTime() - start;

		start = System.nanoTime();
		for (Integer val : data) {
			// Iterate
		}
		long iterTime = System.nanoTime() - start;

		System.out.println("   Using get(i): " + getTime + " ns");
		System.out.println("   Using iterator: " + iterTime + " ns");

		// 4. Remove from end vs beginning
		System.out.println("\n4. Remove Position Test:");

		ArrayList<Integer> list3 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list3.add(i);
		}

		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list3.remove(list3.size() - 1); // Fast
		}
		long endRemove = System.nanoTime() - start;

		ArrayList<Integer> list4 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list4.add(i);
		}

		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			list4.remove(0); // Slow - shifts elements
		}
		long beginRemove = System.nanoTime() - start;

		System.out.println("   Remove from end (1000): " + endRemove + " ns");
		System.out.println("   Remove from beginning (1000): " + beginRemove + " ns");

		// PERFORMANCE TIPS
		System.out.println("\n--- Performance Tips ---");
		System.out.println(">> Pre-size if you know the capacity");
		System.out.println(">> Add elements at the end when possible");
		System.out.println(">> Use get(i) for random access (O(1))");
		System.out.println(">> Remove from end to avoid shifting");
		System.out.println(">> Use Iterator.remove() during iteration");
		System.out.println(">> Use trimToSize() after bulk removals");
		System.out.println(">> Consider LinkedList for frequent insertions at beginning");
	}
}
