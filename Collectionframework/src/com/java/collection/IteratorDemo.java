package com.java.collection;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println("=== ITERATOR DEMO ===\n");
        
        Collection<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        
        System.out.println("Original Collection: " + fruits);
        
        // 1. iterator() - Returns an Iterator
        System.out.println("\n1. Basic Iterator Usage:");
        Iterator<String> iterator1 = fruits.iterator();
        
        System.out.println("Iterating through collection:");
        while (iterator1.hasNext()) {
            String fruit = iterator1.next();
            System.out.println("  - " + fruit);
        }
        
        // 2. Using Iterator to remove elements
        System.out.println("\n2. Removing Elements with Iterator:");
        Iterator<String> iterator2 = fruits.iterator();
        System.out.println("Removing fruits starting with 'B' or 'D':");
        
        while (iterator2.hasNext()) {
            String fruit = iterator2.next();
            if (fruit.startsWith("B") || fruit.startsWith("D")) {
                System.out.println("  Removing: " + fruit);
                iterator2.remove();
            }
        }
        System.out.println("Collection after removal: " + fruits);
        
        // 3. Enhanced for-loop (uses iterator internally)
        System.out.println("\n3. Enhanced For-Loop (uses iterator):");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }
        
        // 4. forEachRemaining() method (Java 8+)
        System.out.println("\n4. Iterator.forEachRemaining() Method:");
        Iterator<String> iterator3 = fruits.iterator();
        iterator3.forEachRemaining(fruit -> 
            System.out.println("  Processing: " + fruit)
        );
        
        // 5. Demonstrating ConcurrentModificationException
        System.out.println("\n5. ConcurrentModificationException Demo:");
        try {
            for (String fruit : fruits) {
                System.out.println("  Current: " + fruit);
                if (fruit.equals("Cherry")) {
                    // This will throw ConcurrentModificationException
                    fruits.remove(fruit);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("  ERROR: Cannot modify collection during iteration!");
            System.out.println("  Use Iterator.remove() instead");
        }
    }
}
