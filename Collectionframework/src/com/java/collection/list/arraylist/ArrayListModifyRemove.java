package com.java.collection.list.arraylist;

import java.util.*;

public class ArrayListModifyRemove {
	public static void main(String[] args) {
		System.out.println("=== MODIFYING & REMOVING ===\n");

		// MODIFYING ELEMENTS
		System.out.println("--- Modifying Elements ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
		System.out.println("Original: " + nums);

		// set(index, element) - replaces element
		Integer old = nums.set(2, 35);
		System.out.println("set(2, 35) returned: " + old);
		System.out.println("New list: " + nums);

		nums.set(0, 15);
		nums.set(nums.size() - 1, 55);
		System.out.println("After modifying first and last: " + nums);

		// replaceAll - applies function to all elements
		System.out.println("\nBefore replaceAll: " + nums);
		nums.replaceAll(n -> n * 2);
		System.out.println("After replaceAll(n -> n * 2): " + nums);

		ArrayList<String> words = new ArrayList<>(Arrays.asList("hello", "world", "java"));
		System.out.println("\nBefore: " + words);
		words.replaceAll(String::toUpperCase);
		System.out.println("After toUpperCase: " + words);

		// REMOVING ELEMENTS
		System.out.println("\n--- Removing Elements ---");

		ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "B"));
		System.out.println("Original: " + list);

		// remove(index)
		String removed = list.remove(2);
		System.out.println("remove(2) returned: " + removed);
		System.out.println("List: " + list);

		// remove(Object) - removes first occurrence
		boolean success = list.remove("B");
		System.out.println("remove('B') success: " + success);
		System.out.println("List: " + list);

		// Integer ArrayList removal confusion
		ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		System.out.println("\nInteger list: " + integers);

		integers.remove(2); // Removes index 2
		System.out.println("After remove(2): " + integers);

		integers.remove(Integer.valueOf(3)); // Removes element 3
		System.out.println("After remove(Integer.valueOf(3)): " + integers);

		// removeAll - removes all matching elements
		ArrayList<String> items = new ArrayList<>(Arrays.asList("X", "Y", "Z", "A", "B", "C"));
		System.out.println("\nBefore removeAll: " + items);
		items.removeAll(Arrays.asList("A", "B", "Z"));
		System.out.println("After removeAll: " + items);

		// retainAll - keeps only matching elements
		ArrayList<String> animals = new ArrayList<>(Arrays.asList("Dog", "Cat", "Bird", "Fish", "Rabbit"));
		System.out.println("\nBefore retainAll: " + animals);
		animals.retainAll(Arrays.asList("Cat", "Dog", "Fish"));
		System.out.println("After retainAll: " + animals);

		// removeIf - removes elements matching condition
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("\nBefore removeIf: " + numbers);
		numbers.removeIf(n -> n % 2 == 0);
		System.out.println("After removeIf(even): " + numbers);

		// clear - removes all elements
		ArrayList<String> toClear = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
		System.out.println("\nBefore clear: " + toClear);
		toClear.clear();
		System.out.println("After clear: " + toClear);
		System.out.println("isEmpty: " + toClear.isEmpty());
	}
}
