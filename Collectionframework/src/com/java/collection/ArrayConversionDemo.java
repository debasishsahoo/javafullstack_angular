package com.java.collection;

import java.util.*;

public class ArrayConversionDemo {
	public static void main(String[] args) {
		System.out.println("=== ARRAY CONVERSION DEMO ===\n");

		Collection<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("Python");
		languages.add("JavaScript");
		languages.add("C++");
		languages.add("Ruby");

		System.out.println("Original Collection: " + languages);

		// 1. toArray() - Converts to Object array
		System.out.println("\n1. toArray() Method:");
		Object[] objectArray = languages.toArray();
		
		System.out.println("Array type: " + objectArray.getClass().getName());
		System.out.print("Array elements: ");
		
		for (Object obj : objectArray) {
			System.out.print(obj + " ");
		}
		System.out.println();

		// 2. toArray(T[] a) - Converts to typed array
		System.out.println("\n2. toArray(T[] a) Method:");

		// Case 1: Array size is smaller than collection
		System.out.println("\nCase 1: Small array (size < collection size)");
		String[] smallArray = new String[2];
		String[] resultArray1 = languages.toArray(smallArray);
		System.out.println("Input array size: " + smallArray.length);
		System.out.println("Result array size: " + resultArray1.length);
		System.out.println("Result array: " + Arrays.toString(resultArray1));
		System.out.println("Are they same reference? " + (smallArray == resultArray1));

		// Case 2: Array size equals collection size
		System.out.println("\nCase 2: Exact size array (size == collection size)");
		String[] exactArray = new String[languages.size()];
		String[] resultArray2 = languages.toArray(exactArray);
		System.out.println("Input array size: " + exactArray.length);
		System.out.println("Result array size: " + resultArray2.length);
		System.out.println("Result array: " + Arrays.toString(resultArray2));
		System.out.println("Are they same reference? " + (exactArray == resultArray2));

		// Case 3: Array size is larger than collection
		System.out.println("\nCase 3: Large array (size > collection size)");
		String[] largeArray = new String[10];
		Arrays.fill(largeArray, "INITIAL");
		System.out.println("Before: " + Arrays.toString(largeArray));
		String[] resultArray3 = languages.toArray(largeArray);
		System.out.println("After:  " + Arrays.toString(resultArray3));
		System.out.println("Are they same reference? " + (largeArray == resultArray3));
		System.out.println("Note: Element after collection is set to null");
	}
}
