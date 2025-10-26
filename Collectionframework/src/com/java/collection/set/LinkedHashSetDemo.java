package com.java.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LinkedHashSetDemo {
	public static void main(String[] args) {
		System.out.println("=== LINKEDHASHSET DEMONSTRATION ===\n");

		// 1. Maintains insertion order
		System.out.println("1. Insertion Order Maintained:");
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Zebra");
		linkedHashSet.add("Apple");
		linkedHashSet.add("Mango");
		linkedHashSet.add("Banana");
		linkedHashSet.add("Cherry");
		System.out.println("LinkedHashSet: " + linkedHashSet);

		Set<String> hashSet = new HashSet<>();
		hashSet.add("Zebra");
		hashSet.add("Apple");
		hashSet.add("Mango");
		hashSet.add("Banana");
		hashSet.add("Cherry");
		System.out.println("HashSet (compare): " + hashSet);
		System.out.println();

		// 2. Constructors
		System.out.println("2. LinkedHashSet Constructors:");

		// Default constructor
		Set<Integer> lhs1 = new LinkedHashSet<>();

		// Constructor with initial capacity
		Set<Integer> lhs2 = new LinkedHashSet<>(32);

		// Constructor with initial capacity and load factor
		Set<Integer> lhs3 = new LinkedHashSet<>(32, 0.75f);

		// Constructor with collection
		List<Integer> numList = Arrays.asList(5, 2, 8, 1, 9, 5, 2);
		Set<Integer> lhs4 = new LinkedHashSet<>(numList);
		System.out.println("From List (order preserved): " + lhs4);
		System.out.println();

		// 3. Iteration demonstration
		System.out.println("3. Predictable Iteration:");
		Set<String> days = new LinkedHashSet<>();
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");

		System.out.print("Iteration 1: ");
		for (String day : days) {
			System.out.print(day + " ");
		}
		System.out.println();

		System.out.print("Iteration 2: ");
		for (String day : days) {
			System.out.print(day + " ");
		}
		System.out.println("\n");

		// 4. Remove and re-add maintains order
		System.out.println("4. Order After Remove and Re-add:");
		System.out.println("Before: " + days);
		days.remove("Wednesday");
		System.out.println("After removing Wednesday: " + days);
		days.add("Wednesday");
		System.out.println("After re-adding Wednesday: " + days);
		System.out.println();

		// 5. Access order vs insertion order
		System.out.println("5. LinkedHashSet uses Insertion Order:");
		Set<Integer> accessOrder = new LinkedHashSet<>();
		accessOrder.add(1);
		accessOrder.add(2);
		accessOrder.add(3);
		accessOrder.add(4);

		// Access elements (contains doesn't change order in LinkedHashSet)
		accessOrder.contains(2);
		accessOrder.contains(4);
		System.out.println("After accessing 2 and 4: " + accessOrder);
		System.out.println("Order unchanged (not access-order)");
		System.out.println();

		// 6. Performance comparison
		System.out.println("6. Performance Comparison:");
		Set<Integer> lhsPerf = new LinkedHashSet<>();
		Set<Integer> hsPerf = new HashSet<>();

		long start = System.nanoTime();
		for (int i = 0; i < 50000; i++) {
			lhsPerf.add(i);
		}
		long lhsTime = System.nanoTime() - start;

		start = System.nanoTime();
		for (int i = 0; i < 50000; i++) {
			hsPerf.add(i);
		}
		long hsTime = System.nanoTime() - start;

		System.out.println("LinkedHashSet add time: " + lhsTime / 1000000.0 + " ms");
		System.out.println("HashSet add time: " + hsTime / 1000000.0 + " ms");
		System.out.println("LinkedHashSet is slightly slower due to maintaining order");
	}
}
