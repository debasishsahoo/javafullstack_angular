package com.java.collection.list.arraylist;

import java.util.*;

public class ArrayListIteration {
	public static void main(String[] args) {
		System.out.println("=== ITERATION METHODS ===\n");

		ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));

		// METHOD 1: Traditional for loop with index
		System.out.println("1. Traditional for loop:");
		for (int i = 0; i < fruits.size(); i++) {
			System.out.println("   [" + i + "]: " + fruits.get(i));
		}

		// METHOD 2: Enhanced for loop (for-each)
		System.out.println("\n2. Enhanced for loop:");
		for (String fruit : fruits) {
			System.out.println("   " + fruit);
		}

		// METHOD 3: Iterator
		System.out.println("\n3. Iterator:");
		Iterator<String> iterator = fruits.iterator();
		while (iterator.hasNext()) {
			System.out.println("   " + iterator.next());
		}

		// METHOD 4: ListIterator (bidirectional)
		System.out.println("\n4. ListIterator (forward):");
		ListIterator<String> listIter = fruits.listIterator();
		while (listIter.hasNext()) {
			System.out.println("   " + listIter.next());
		}

		System.out.println("\n   ListIterator (backward):");
		while (listIter.hasPrevious()) {
			System.out.println("   " + listIter.previous());
		}

		// METHOD 5: forEach with lambda
		System.out.println("\n5. forEach with lambda:");
		fruits.forEach(fruit -> System.out.println("   " + fruit));

		// METHOD 6: forEach with method reference
		System.out.println("\n6. forEach with method reference:");
		System.out.print("   ");
		fruits.forEach(System.out::println);

		// METHOD 7: Stream API
		System.out.println("\n7. Stream API:");
		fruits.stream().forEach(f -> System.out.println("   " + f));

		// METHOD 8: Enumeration
		System.out.println("\n8. Enumeration:");
		Enumeration<String> enumeration = Collections.enumeration(fruits);
		while (enumeration.hasMoreElements()) {
			System.out.println("   " + enumeration.nextElement());
		}

		// SAFE REMOVAL DURING ITERATION
		System.out.println("\n--- Safe Removal During Iteration ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("Original: " + nums);

		// Using Iterator for safe removal
		Iterator<Integer> numIter = nums.iterator();
		while (numIter.hasNext()) {
			Integer num = numIter.next();
			if (num % 2 == 0) {
				numIter.remove();
			}
		}
		System.out.println("After removing evens: " + nums);

		// WRONG WAY - ConcurrentModificationException
		System.out.println("\n--- Wrong Way (Throws Exception) ---");
		ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		try {
			for (Integer n : test) {
				if (n % 2 == 0) {
					test.remove(n); // DON'T DO THIS!
				}
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Exception: " + e.getClass().getSimpleName());
		}

		// ITERATION WITH INDEX AND VALUE
		System.out.println("\n--- Index and Value Together ---");

		for (int i = 0; i < fruits.size(); i++) {
			System.out.println("   Position " + i + ": " + fruits.get(i));
		}

		// ListIterator with index
		System.out.println("\n--- ListIterator with Index ---");
		ListIterator<String> indexIter = fruits.listIterator();
		while (indexIter.hasNext()) {
			int idx = indexIter.nextIndex();
			String val = indexIter.next();
			System.out.println("   Index " + idx + ": " + val);
		}
	}
}