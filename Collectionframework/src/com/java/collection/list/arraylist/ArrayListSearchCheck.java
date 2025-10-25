package com.java.collection.list.arraylist;

import java.util.*;

public class ArrayListSearchCheck {
	public static void main(String[] args) {
		System.out.println("=== SEARCHING & CHECKING ===\n");

		// SEARCHING ELEMENTS
		System.out.println("--- Searching Elements ---");

		ArrayList<String> animals = new ArrayList<>(
				Arrays.asList("Cat", "Dog", "Bird", "Dog", "Fish", "Dog", "Rabbit"));
		System.out.println("ArrayList: " + animals);

		// contains - checks if element exists
		System.out.println("\ncontains('Cat'): " + animals.contains("Cat"));
		System.out.println("contains('Lion'): " + animals.contains("Lion"));

		// indexOf - returns first occurrence index
		System.out.println("\nindexOf('Dog'): " + animals.indexOf("Dog"));
		System.out.println("indexOf('Elephant'): " + animals.indexOf("Elephant"));

		// lastIndexOf - returns last occurrence index
		System.out.println("\nlastIndexOf('Dog'): " + animals.lastIndexOf("Dog"));

		// Finding all occurrences
		System.out.println("\nAll occurrences of 'Dog':");
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).equals("Dog")) {
				System.out.println("  Index: " + i);
			}
		}

		// Using streams to find elements
		System.out.println("\nAnimals starting with 'D':");
		animals.stream().filter(a -> a.startsWith("D")).forEach(a -> System.out.println("  " + a));

		// CHECKING OPERATIONS
		System.out.println("\n--- Checking Operations ---");

		ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
		System.out.println("ArrayList: " + fruits);

		// size
		System.out.println("\nsize(): " + fruits.size());

		// isEmpty
		System.out.println("isEmpty(): " + fruits.isEmpty());

		ArrayList<String> empty = new ArrayList<>();
		System.out.println("\nEmpty list isEmpty(): " + empty.isEmpty());
		System.out.println("Empty list size(): " + empty.size());

		// containsAll - checks if all elements exist
		System.out
				.println("\ncontainsAll(['Apple', 'Cherry']): " + fruits.containsAll(Arrays.asList("Apple", "Cherry")));
		System.out.println("containsAll(['Apple', 'Mango']): " + fruits.containsAll(Arrays.asList("Apple", "Mango")));

		// equals - compares with another list
		ArrayList<String> fruits2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
		ArrayList<String> fruits3 = new ArrayList<>(Arrays.asList("Apple", "Banana"));

		System.out.println("\nfruits.equals(fruits2): " + fruits.equals(fruits2));
		System.out.println("fruits.equals(fruits3): " + fruits.equals(fruits3));

		// hashCode
		System.out.println("\nfruits.hashCode(): " + fruits.hashCode());
		System.out.println("fruits2.hashCode(): " + fruits2.hashCode());

		// BULK OPERATIONS
		System.out.println("\n--- Bulk Operations ---");

		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));

		System.out.println("List1: " + list1);
		System.out.println("List2: " + list2);

		// Union
		ArrayList<Integer> union = new ArrayList<>(list1);
		union.addAll(list2);
		System.out.println("\nUnion: " + union);

		// Intersection
		ArrayList<Integer> intersection = new ArrayList<>(list1);
		intersection.retainAll(list2);
		System.out.println("Intersection: " + intersection);

		// Difference
		ArrayList<Integer> difference = new ArrayList<>(list1);
		difference.removeAll(list2);
		System.out.println("Difference (list1 - list2): " + difference);

		// Collections.frequency
		ArrayList<String> letters = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A", "B"));
		int count = Collections.frequency(letters, "A");
		System.out.println("\nFrequency of 'A' in " + letters + ": " + count);

		// Collections.disjoint
		ArrayList<Integer> set1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> set2 = new ArrayList<>(Arrays.asList(4, 5, 6));
		boolean disjoint = Collections.disjoint(set1, set2);
		System.out.println("\nAre " + set1 + " and " + set2 + " disjoint? " + disjoint);
	}
}
