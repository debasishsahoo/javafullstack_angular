package com.java.collection.set.hashset;

import java.util.HashSet;

public class ContainsOperationDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");

        System.out.println("HashSet: " + set);
        System.out.println("\n--- Testing contains() method ---\n");

        String[] testElements = {"Java", "Ruby", "Python", "Go", "JavaScript"};

        for (String element : testElements) {
            boolean exists = set.contains(element);
            System.out.println("Contains '" + element + "': " + exists);
        }

        // Performance test
        System.out.println("\n--- Performance Test ---");
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            set.contains("Java");
        }
        long endTime = System.nanoTime();
        System.out.println("1 million lookups took: " +
            (endTime - startTime) / 1000000.0 + " ms");
    }
}
