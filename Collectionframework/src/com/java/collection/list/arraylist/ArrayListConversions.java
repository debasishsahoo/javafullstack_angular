package com.java.collection.list.arraylist;

import java.util.*;

public class ArrayListConversions {
	public static void main(String[] args) {
		System.out.println("=== ARRAYLIST CONVERSIONS ===\n");

		ArrayList<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four"));
		System.out.println("Original ArrayList: " + list);

		// TO ARRAY
		System.out.println("\n--- To Array ---");

		// toArray() - returns Object[]
		Object[] objArr = list.toArray();
		System.out.println("toArray(): " + Arrays.toString(objArr));

		// toArray(T[]) - returns typed array
		String[] strArr = list.toArray(new String[0]);
		System.out.println("toArray(String[]): " + Arrays.toString(strArr));

		// Exact size array
		String[] strArr2 = list.toArray(new String[list.size()]);
		System.out.println("toArray(exact size): " + Arrays.toString(strArr2));

		// TO OTHER COLLECTIONS
		System.out.println("\n--- To Other Collections ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4));
		System.out.println("ArrayList with dupes: " + nums);

		// To HashSet (removes duplicates)
		HashSet<Integer> hashSet = new HashSet<>(nums);
		System.out.println("To HashSet: " + hashSet);

		// To LinkedList
		LinkedList<String> linkedList = new LinkedList<>(list);
		System.out.println("\nTo LinkedList: " + linkedList);

		// To TreeSet (sorted, no duplicates)
		TreeSet<String> treeSet = new TreeSet<>(list);
		System.out.println("To TreeSet: " + treeSet);

		// FROM ARRAY
		System.out.println("\n--- From Array ---");

		String[] array = { "A", "B", "C", "D" };
		ArrayList<String> fromArr = new ArrayList<>(Arrays.asList(array));
		System.out.println("From array: " + fromArr);

		// FROM STRING
		System.out.println("\n--- From String ---");

		String text = "Hello";
		ArrayList<Character> chars = new ArrayList<>();
		for (char c : text.toCharArray()) {
			chars.add(c);
		}
		System.out.println("String to ArrayList<Character>: " + chars);

		// TO STRING
		System.out.println("\n--- To String ---");

		// Using String.join
		String joined = String.join(", ", list);
		System.out.println("Joined with comma: " + joined);

		// Using toString()
		String asString = list.toString();
		System.out.println("Using toString(): " + asString);

		// Custom format
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1) {
				sb.append(" | ");
			}
		}
		System.out.println("Custom format: " + sb.toString());

		// PRIMITIVE ARRAYS
		System.out.println("\n--- With Primitive Arrays ---");

		// int[] to ArrayList<Integer>
		int[] intArr = { 1, 2, 3, 4, 5 };
		ArrayList<Integer> intList = new ArrayList<>();
		for (int num : intArr) {
			intList.add(num);
		}
		System.out.println("int[] to ArrayList: " + intList);

		// ArrayList<Integer> to int[]
		int[] backToInt = intList.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("ArrayList to int[]: " + Arrays.toString(backToInt));

		// COLLECTION COPYING
		System.out.println("\n--- Collection Copying ---");

		ArrayList<String> original = new ArrayList<>(Arrays.asList("X", "Y", "Z"));

		// Method 1: Constructor
		ArrayList<String> copy1 = new ArrayList<>(original);
		System.out.println("Copy via constructor: " + copy1);

		// Method 2: addAll
		ArrayList<String> copy2 = new ArrayList<>();
		copy2.addAll(original);
		System.out.println("Copy via addAll: " + copy2);

		// Method 3: clone
		@SuppressWarnings("unchecked")
		ArrayList<String> copy3 = (ArrayList<String>) original.clone();
		System.out.println("Copy via clone: " + copy3);
	}
}