package com.java.collection;

import java.util.ArrayList;
import java.util.Collection;

public class BulkOperationsDemo {

	public static void main(String[] args) {
		System.out.println("=== BULK OPERATIONS DEMO ===\n");

		Collection<Integer> collection1 = new ArrayList<>();
		collection1.add(10);
		collection1.add(20);
		collection1.add(30);
		collection1.add(40);

		Collection<Integer> collection2 = new ArrayList<>();
		collection2.add(30);
		collection2.add(40);
		collection2.add(50);
		collection2.add(60);

		System.out.println("Collection 1: " + collection1);
		System.out.println("Collection 2: " + collection2);

		// 1. addAll(Collection c) - Adds all elements from another collection
		System.out.println("\n1. addAll() Method:");

		Collection<Integer> combinedCollection = new ArrayList<>(collection1);

		boolean allAdded = combinedCollection.addAll(collection2);

		System.out.println("All elements added: " + allAdded);

		System.out.println("Combined collection: " + combinedCollection);

		// 2. containsAll(Collection c) - Checks if contains all elements
		System.out.println("\n2. containsAll() Method:");
		Collection<Integer> subset = new ArrayList<>();
		subset.add(10);
		subset.add(20);

		System.out.println("Subset to check: " + subset);
		System.out.println("Collection1 contains all of subset? " + collection1.containsAll(subset));

		subset.add(99);

		System.out.println("Subset with 99: " + subset);
		System.out.println("Collection1 contains all of subset? " + collection1.containsAll(subset));

		// 3. removeAll(Collection c) - Removes all matching elements
		System.out.println("\n3. removeAll() Method:");
		Collection<Integer> forRemoval = new ArrayList<>(collection1);

		System.out.println("Before removeAll: " + forRemoval);
		forRemoval.removeAll(collection2);

		System.out.println("After removing Collection2 elements: " + forRemoval);

		// 4. retainAll(Collection c) - Retains only matching elements (intersection)
		System.out.println("\n4. retainAll() Method:");
		Collection<Integer> forRetain = new ArrayList<>(collection1);

		System.out.println("Before retainAll: " + forRetain);
		forRetain.retainAll(collection2);
		System.out.println("After retaining only Collection2 elements: " + forRetain);

		System.out.println("(This is the intersection of both collections)");

	}

}
