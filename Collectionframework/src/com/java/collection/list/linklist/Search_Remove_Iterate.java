package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Search_Remove_Iterate {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST SEARCH, REMOVE & ITERATION ===\n");

		demonstrateSearchingOperations();
		demonstrateRemovingOperations();
		demonstrateIterationMethods();

	}

	// SEARCHING OPERATIONS
	public static void demonstrateSearchingOperations() {
		System.out.println("\n--- SEARCHING OPERATIONS ---");

		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Apple"));
		System.out.println("List: " + list);

		// contains(Object o)
		boolean hasApple = list.contains("Apple");
		System.out.println("\ncontains('Apple'): " + hasApple);
		System.out.println("contains('Mango'): " + list.contains("Mango"));

		// indexOf(Object o) - first occurrence
		int firstApple = list.indexOf("Apple");
		System.out.println("\nindexOf('Apple'): " + firstApple);
		System.out.println("indexOf('Mango'): " + list.indexOf("Mango")); // Returns -1

		// lastIndexOf(Object o) - last occurrence
		int lastApple = list.lastIndexOf("Apple");
		System.out.println("\nlastIndexOf('Apple'): " + lastApple);

		// Searching with custom condition
		System.out.println("\n--- Custom Search ---");
		String target = list.stream().filter(s -> s.startsWith("C")).findFirst().orElse("Not found");
		System.out.println("First element starting with 'C': " + target);
	}

	// REMOVING OPERATIONS
	public static void demonstrateRemovingOperations() {
		System.out.println("\n--- REMOVING OPERATIONS ---");

		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("A", "B", "C", "D", "E", "A"));
		System.out.println("Initial list: " + list);

		// remove(Object o) - removes first occurrence
		boolean removed1 = list.remove("A");
		System.out.println("\nremove('A'): " + removed1);
		System.out.println("After removal: " + list);

		// remove(int index) - removes at specific position
		String removed2 = list.remove(2);
		System.out.println("\nremove(2): removed=" + removed2);
		System.out.println("After removal: " + list);

		// removeAll(Collection c)
		list.addAll(Arrays.asList("X", "Y", "Z"));
		System.out.println("\nList: " + list);
		list.removeAll(Arrays.asList("X", "Y", "Z"));
		System.out.println("After removeAll(['X','Y','Z']): " + list);

		// retainAll(Collection c) - keeps only specified elements
		list.addAll(Arrays.asList("P", "Q", "R"));
		System.out.println("\nList: " + list);
		list.retainAll(Arrays.asList("B", "D", "P"));
		System.out.println("After retainAll(['B','D','P']): " + list);

		// removeIf(Predicate) - Java 8+
		list.clear();
		list.addAll(Arrays.asList("Apple", "Banana", "Apricot", "Cherry"));
		System.out.println("\nList: " + list);
		list.removeIf(s -> s.startsWith("A"));
		System.out.println("After removeIf(starts with 'A'): " + list);

		// clear()
		list.clear();
		System.out.println("\nAfter clear(): " + list);
		System.out.println("isEmpty(): " + list.isEmpty());
	}

	// ITERATION METHODS
	public static void demonstrateIterationMethods() {
		System.out.println("\n--- ITERATION METHODS ---");

		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("One", "Two", "Three", "Four", "Five"));

		// 1. For-each loop
		System.out.println("\n1. For-each loop:");
		for (String item : list) {
			System.out.println("   " + item);
		}

		// 2. Iterator
		System.out.println("\n2. Iterator:");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println("   " + iter.next());
		}

		// 3. ListIterator (bidirectional)
		System.out.println("\n3. ListIterator (forward):");
		ListIterator<String> listIter = list.listIterator();
		while (listIter.hasNext()) {
			System.out.println("   Index " + listIter.nextIndex() + ": " + listIter.next());
		}

		System.out.println("\n4. ListIterator (backward):");
		while (listIter.hasPrevious()) {
			System.out.println("   Index " + listIter.previousIndex() + ": " + listIter.previous());
		}

		// 4. descendingIterator
		System.out.println("\n5. descendingIterator:");
		Iterator<String> descIter = list.descendingIterator();
		while (descIter.hasNext()) {
			System.out.println("   " + descIter.next());
		}

		// 5. forEach (Java 8+)
		System.out.println("\n6. forEach method:");
		list.forEach(item -> System.out.println("   " + item));

		// 6. Stream
		System.out.println("\n7. Stream:");
		list.stream().forEach(item -> System.out.println("   " + item));

		// 7. Classic for loop (not recommended for LinkedList)
		System.out.println("\n8. Index-based loop (NOT RECOMMENDED - O(n²)):");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("   " + list.get(i));
		}

	}
}
