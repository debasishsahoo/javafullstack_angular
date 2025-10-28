package com.java.collection.set.hashset;

import java.util.HashSet;

public class DetailedAddOperation {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();

        System.out.println("Initial state:");
        System.out.println("Size: " + set.size());
        System.out.println("Empty: " + set.isEmpty());

        System.out.println("\n--- Adding 'Java' ---");
        boolean added1 = set.add("Java");
        System.out.println("Element added: " + added1);
        System.out.println("Size after add: " + set.size());

        System.out.println("\n--- Adding 'Java' again (duplicate) ---");
        boolean added2 = set.add("Java");
        System.out.println("Element added: " + added2); // false, already exists
        System.out.println("Size after duplicate add: " + set.size());

        System.out.println("\n--- Adding 'Python' ---");
        boolean added3 = set.add("Python");
        System.out.println("Element added: " + added3);
        System.out.println("Final size: " + set.size());

        System.out.println("\nFinal set: " + set);


	}

}
