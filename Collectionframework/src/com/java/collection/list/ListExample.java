package com.java.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		// Creating a List using ArrayList
		List<String> fruits = new ArrayList<>();
		// Adding elements
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Cherry");
		fruits.add("Banana"); // duplicate allowed
		// Accessing elements(index based)
		System.out.println("First fruit: " + fruits.get(0));
		// Modifying elements(index based)
		fruits.set(2, "Mango");
		// Removing elements
		fruits.remove("Banana"); // removes first occurrence
		// Iterating using for-each loop
		System.out.println("\nList elements:");
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		// Sublist
		List<String> sub = fruits.subList(0, 2);
		System.out.println("\nSublist: " + sub);
		// Index-based operations
		System.out.println("\nIndex of Mango: " + fruits.indexOf("Mango"));

		// Size
		System.out.println("Size: " + fruits.size());

		// Checking if contains
		System.out.println("Contains Orange? " + fruits.contains("Orange"));

	}

}
