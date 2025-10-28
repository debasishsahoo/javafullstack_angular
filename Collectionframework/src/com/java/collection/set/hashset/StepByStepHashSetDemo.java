package com.java.collection.set.hashset;

import java.util.*;

public class StepByStepHashSetDemo {

    // Helper method to simulate hash calculation
    static int calculateBucketIndex(String key, int capacity) {
        int hash = key.hashCode();
        hash = hash ^ (hash >>> 16);
        return (capacity - 1) & hash;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int capacity = 16; // Default capacity

        String[] elements = {"Java", "Python", "C++", "JavaScript", "Ruby", "Go"};

        System.out.println("Adding elements to HashSet (capacity = " + capacity + "):\n");
        System.out.println("=".repeat(80));

        for (String element : elements) {
            int hashCode = element.hashCode();
            int bucketIndex = calculateBucketIndex(element, capacity);
            boolean added = set.add(element);

            System.out.println("\nElement: '" + element + "'");
            System.out.println("  Hash Code:     " + hashCode);
            System.out.println("  Bucket Index:  " + bucketIndex);
            System.out.println("  Added:         " + added);
            System.out.println("  Current Size:  " + set.size());
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("\nFinal HashSet: " + set);
        System.out.println("Total unique elements: " + set.size());

        // Try adding duplicate
        System.out.println("\n" + "=".repeat(80));
        System.out.println("\nAttempting to add duplicate 'Java':");
        boolean addedDuplicate = set.add("Java");
        System.out.println("  Added: " + addedDuplicate);
        System.out.println("  Size after duplicate attempt: " + set.size());
    }
}

