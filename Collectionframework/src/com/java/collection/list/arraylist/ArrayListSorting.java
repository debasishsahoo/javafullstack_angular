package com.java.collection.list.arraylist;

import java.util.*;

public class ArrayListSorting {
	public static void main(String[] args) {
		System.out.println("=== SORTING & ORDERING ===\n");

		// SORTING NUMBERS
		System.out.println("--- Sorting Numbers ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7, 4, 6));
		System.out.println("Original: " + nums);

		// sort - ascending
		nums.sort(Comparator.naturalOrder());
		System.out.println("Ascending: " + nums);

		// sort - descending
		nums.sort(Comparator.reverseOrder());
		System.out.println("Descending: " + nums);

		// Collections.sort
		ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(15, 3, 9, 21, 6));
		System.out.println("\nOriginal: " + nums2);
		Collections.sort(nums2);
		System.out.println("Collections.sort(): " + nums2);

		// SORTING STRINGS
		System.out.println("\n--- Sorting Strings ---");

		ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Alice", "Bob", "Diana", "Charlie"));
		System.out.println("Original: " + names);
		names.sort(Comparator.naturalOrder());
		System.out.println("Alphabetically: " + names);

		// Custom comparator - by length
		ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "pie", "banana", "cat", "elephant"));
		System.out.println("\nOriginal: " + words);
		words.sort(Comparator.comparingInt(String::length));
		System.out.println("By length: " + words);

		// Multiple criteria
		words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
		System.out.println("By length, then alphabetically: " + words);

		// REVERSE
		System.out.println("\n--- Reversing ---");

		ArrayList<Integer> toReverse = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("Original: " + toReverse);
		Collections.reverse(toReverse);
		System.out.println("Reversed: " + toReverse);

		// SHUFFLE
		System.out.println("\n--- Shuffling ---");

		ArrayList<Integer> toShuffle = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("Original: " + toShuffle);
		Collections.shuffle(toShuffle);
		System.out.println("Shuffled: " + toShuffle);

		// ROTATE
		System.out.println("\n--- Rotating ---");

		ArrayList<Integer> toRotate = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("Original: " + toRotate);
		Collections.rotate(toRotate, 2);
		System.out.println("Rotated by 2: " + toRotate);

		// SWAP
		System.out.println("\n--- Swapping ---");

		ArrayList<String> toSwap = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
		System.out.println("Original: " + toSwap);
		Collections.swap(toSwap, 0, 3);
		System.out.println("After swap(0, 3): " + toSwap);

		// FILL
		System.out.println("\n--- Filling ---");

		ArrayList<String> toFill = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
		System.out.println("Original: " + toFill);
		Collections.fill(toFill, "X");
		System.out.println("After fill('X'): " + toFill);

		// MIN AND MAX
		System.out.println("\n--- Min and Max ---");

		ArrayList<Integer> values = new ArrayList<>(Arrays.asList(10, 5, 20, 3, 15));
		System.out.println("Values: " + values);
		System.out.println("Min: " + Collections.min(values));
		System.out.println("Max: " + Collections.max(values));

		// BINARY SEARCH (requires sorted list)
		System.out.println("\n--- Binary Search ---");

		ArrayList<Integer> sorted = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
		System.out.println("Sorted: " + sorted);

		int idx = Collections.binarySearch(sorted, 7);
		System.out.println("Index of 7: " + idx);

		int notFound = Collections.binarySearch(sorted, 6);
		System.out.println("Index of 6 (not found): " + notFound + " (negative)");
	}
}
