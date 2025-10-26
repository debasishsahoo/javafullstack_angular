package com.java.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> fruits = new HashSet<>();

		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		fruits.add("Apple"); // Duplicate, will not be added

		System.out.println("Fruits: " + fruits);
		System.out.println("Contains Banana? " + fruits.contains("Banana"));

		fruits.remove("Orange");
		System.out.println("After removing Orange: " + fruits);

		for (String fruit : fruits) {
			System.out.println(fruit);
		}
	}
}
