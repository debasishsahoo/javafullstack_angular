package com.java.collection.list.arraylist;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSubListClone {
	public static void main(String[] args) {
		System.out.println("=== SUBLIST & CLONING ===\n");

		// SUBLIST OPERATIONS
		System.out.println("--- SubList Operations ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println("Original: " + nums);

		// subList(from, to) - returns view
		List<Integer> sub = nums.subList(2, 6);
		System.out.println("\nsubList(2, 6): " + sub);

		// Modifying sublist affects original
		sub.set(0, 99);
		System.out.println("After sub.set(0, 99):");
		System.out.println("  SubList: " + sub);
		System.out.println("  Original: " + nums);

		// Adding to sublist
		sub.add(88);
		System.out.println("\nAfter sub.add(88):");
		System.out.println("  SubList: " + sub);
		System.out.println("  Original: " + nums);

		// Clearing sublist removes from original
		ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
		System.out.println("\nOriginal: " + nums2);
		nums2.subList(2, 5).clear();
		System.out.println("After subList(2, 5).clear(): " + nums2);

		// Getting first N elements
		ArrayList<String> items = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
		List<String> first3 = items.subList(0, 3);
		System.out.println("\nFirst 3: " + first3);

		// Getting last N elements
		int n = 3;
		List<String> last3 = items.subList(items.size() - n, items.size());
		System.out.println("Last 3: " + last3);

		// Copying portion to new ArrayList
		ArrayList<String> copied = new ArrayList<>(items.subList(1, 4));
		System.out.println("\nCopied portion [1-4]: " + copied);
		copied.add("NEW");
		System.out.println("After adding to copy: " + copied);
		System.out.println("Original unchanged: " + items);

		// CLONING
		System.out.println("\n--- Cloning Operations ---");

		ArrayList<String> original = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
		System.out.println("Original: " + original);

		// Method 1: clone() - shallow copy
		@SuppressWarnings("unchecked")
		ArrayList<String> cloned = (ArrayList<String>) original.clone();
		System.out.println("\n1. Using clone(): " + cloned);

		cloned.add("Date");
		System.out.println("   After adding to clone: " + cloned);
		System.out.println("   Original unchanged: " + original);

		// Method 2: Constructor
		ArrayList<String> copy1 = new ArrayList<>(original);
		System.out.println("\n2. Using constructor: " + copy1);

		// Method 3: addAll
		ArrayList<String> copy2 = new ArrayList<>();
		copy2.addAll(original);
		System.out.println("\n3. Using addAll: " + copy2);

		// Method 4: Stream
		ArrayList<String> copy3 = original.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("\n4. Using Stream: " + copy3);

		// Method 5: Collections.copy (needs destination with size)
		ArrayList<String> dest = new ArrayList<>(Arrays.asList("", "", ""));
		Collections.copy(dest, original);
		System.out.println("\n5. Using Collections.copy: " + dest);

		// SHALLOW VS DEEP COPY
		System.out.println("\n--- Shallow vs Deep Copy ---");

		ArrayList<StringBuilder> mutable = new ArrayList<>();
		mutable.add(new StringBuilder("Hello"));
		mutable.add(new StringBuilder("World"));

		// Shallow copy - references same objects
		@SuppressWarnings("unchecked")
		ArrayList<StringBuilder> shallow = (ArrayList<StringBuilder>) mutable.clone();

		System.out.println("Original: " + mutable);
		System.out.println("Shallow copy: " + shallow);

		// Modifying object affects both
		shallow.get(0).append("!");
		System.out.println("\nAfter modifying shallow copy:");
		System.out.println("Original: " + mutable + " (affected!)");
		System.out.println("Shallow: " + shallow);

		// Deep copy - creates new objects
		ArrayList<StringBuilder> deep = new ArrayList<>();
		for (StringBuilder sb : mutable) {
			deep.add(new StringBuilder(sb));
		}

		deep.get(0).append("?");
		System.out.println("\nAfter modifying deep copy:");
		System.out.println("Original: " + mutable + " (unchanged)");
		System.out.println("Deep: " + deep);
	}
}
