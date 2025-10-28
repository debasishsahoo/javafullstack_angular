package com.java.collection.set.hashset;

import java.util.HashSet;

public class RemoveOperationDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("JavaScript");

        System.out.println("Initial set: " + set);
        System.out.println("Initial size: " + set.size());

        System.out.println("\n--- Removing 'Python' ---");
        boolean removed1 = set.remove("Python");
        System.out.println("Removed: " + removed1);
        System.out.println("Set after removal: " + set);
        System.out.println("Size: " + set.size());

        System.out.println("\n--- Attempting to remove 'Ruby' (doesn't exist) ---");
        boolean removed2 = set.remove("Ruby");
        System.out.println("Removed: " + removed2);
        System.out.println("Set unchanged: " + set);
        System.out.println("Size: " + set.size());

        System.out.println("\n--- Removing all elements ---");
        set.remove("Java");
        set.remove("C++");
        set.remove("JavaScript");
        System.out.println("Set after removing all: " + set);
        System.out.println("Is empty: " + set.isEmpty());
    }
}
