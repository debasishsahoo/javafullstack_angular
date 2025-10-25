package com.java.collection.list.arraylist;


import java.util.*;

public class ArrayListBasics {
	public static void main(String[] args) {
		System.out.println("=== ARRAYLIST BASICS ===\n");

		// CONSTRUCTORS
		System.out.println("--- Constructors ---");

		// Default constructor (capacity = 10)
		ArrayList<String> list1 = new ArrayList<>();
		System.out.println("1. Default: " + list1 + ", Size: " + list1.size());

		// With initial capacity
		ArrayList<String> list2 = new ArrayList<>(20);
		System.out.println("2. Capacity 20: " + list2 + ", Size: " + list2.size());

		// From another collection
		ArrayList<String> source = new ArrayList<>();
		source.add("Apple");
		source.add("Banana");
		ArrayList<String> list3 = new ArrayList<>(source);
		System.out.println("3. From collection: " + list3);

		// With initial values
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println("4. With Arrays.asList: " + nums);

		ArrayList<String> list4 = new ArrayList<>(List.of("X", "Y", "Z"));
		System.out.println("5. With List.of: " + list4);

		// ADDING ELEMENTS
		System.out.println("\n--- Adding Elements ---");

		ArrayList<String> fruits = new ArrayList<>();

		// add(element) - adds to end
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Cherry");
		System.out.println("After adding: " + fruits);

		// add(index, element) - inserts at position
		fruits.add(1, "Avocado");
		System.out.println("After add(1, 'Avocado'): " + fruits);

		fruits.add(0, "Apricot");
		System.out.println("After add(0, 'Apricot'): " + fruits);

		// addAll(Collection) - adds multiple elements
		ArrayList<String> more = new ArrayList<>(Arrays.asList("Date", "Elderberry"));
		fruits.addAll(more);
		System.out.println("After addAll: " + fruits);

		// addAll(index, Collection) - inserts at position
		ArrayList<String> tropical = new ArrayList<>(Arrays.asList("Mango", "Papaya"));
		fruits.addAll(2, tropical);
		System.out.println("After addAll(2, tropical): " + fruits);

		// Adding null and duplicates
		fruits.add(null);
		fruits.add("Apple");
		System.out.println("With null and duplicate: " + fruits);

		// ACCESSING ELEMENTS
		System.out.println("\n--- Accessing Elements ---");

		ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));
		System.out.println("Colors: " + colors);

		System.out.println("get(0): " + colors.get(0));
		System.out.println("get(2): " + colors.get(2));
		System.out.println("get(size-1): " + colors.get(colors.size() - 1));

		System.out.println("\nAll elements:");
		for (int i = 0; i < colors.size(); i++) {
			System.out.println("  [" + i + "]: " + colors.get(i));
		}

		// IndexOutOfBoundsException
		try {
			colors.get(10);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nget(10) throws: " + e.getClass().getSimpleName());
		}
	}
}
