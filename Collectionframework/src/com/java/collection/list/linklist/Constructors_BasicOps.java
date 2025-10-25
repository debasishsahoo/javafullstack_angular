package com.java.collection.list.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Constructors_BasicOps {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST CONSTRUCTORS & BASIC OPERATIONS ===\n");

		demonstrateConstructors();
		demonstrateBasicListOperations();
	}

	// 1. CONSTRUCTORS
	public static void demonstrateConstructors() {
		System.out.println("\n--- 1. LINKEDLIST CONSTRUCTORS ---");

		// Constructor 1: No-argument constructor
		LinkedList<String> list1 = new LinkedList<>();
		System.out.println("1. Default constructor: " + list1);
		System.out.println("   Size: " + list1.size());

		// Constructor 2: Constructor with collection
		List<String> sourceList = Arrays.asList("Apple", "Banana", "Cherry");
		LinkedList<String> list2 = new LinkedList<>(sourceList);
		System.out.println("\n2. Constructor from collection: " + list2);
		System.out.println("   Size: " + list2.size());

		// Creating with initial values
		LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("\n3. Created with Arrays.asList: " + numbers);

		// Creating from ArrayList
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.addAll(Arrays.asList("X", "Y", "Z"));
		LinkedList<String> fromArrayList = new LinkedList<>(arrayList);
		System.out.println("\n4. Created from ArrayList: " + fromArrayList);
	}

	// 2. BASIC LIST OPERATIONS
	public static void demonstrateBasicListOperations() {
		System.out.println("\n--- 2. BASIC LIST OPERATIONS ---");

		LinkedList<String> list = new LinkedList<>();

		// add(E element) - adds to the end
		list.add("First");
		list.add("Second");
		list.add("Third");
		System.out.println("After add(): " + list);

		// add(int index, E element) - inserts at position
		list.add(1, "Inserted");
		System.out.println("After add(1, 'Inserted'): " + list);

		// addAll(Collection c)
		LinkedList<String> more = new LinkedList<>();
		more.add("Fourth");
		more.add("Fifth");
		list.addAll(more);
		System.out.println("After addAll(): " + list);

		// addAll(int index, Collection c)
		list.addAll(2, Arrays.asList("A", "B"));
		System.out.println("After addAll(2, ['A','B']): " + list);

		// get(int index)
		String element = list.get(0);
		System.out.println("\nget(0): " + element);

		// set(int index, E element)
		String oldValue = list.set(0, "FIRST");
		System.out.println("set(0, 'FIRST'): old=" + oldValue + ", new list=" + list);

		// size()
		System.out.println("\nsize(): " + list.size());

		// isEmpty()
		System.out.println("isEmpty(): " + list.isEmpty());

		// contains(Object o)
		System.out.println("contains('Second'): " + list.contains("Second"));

		// clear()
		LinkedList<String> temp = new LinkedList<>(list);
		temp.clear();
		System.out.println("\nAfter clear(): " + temp);
	}
}
