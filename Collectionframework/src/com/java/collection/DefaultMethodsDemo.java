package com.java.collection;

import java.util.*;
import java.util.function.Predicate;

public class DefaultMethodsDemo {
    public static void main(String[] args) {
        System.out.println("=== DEFAULT METHODS DEMO ===\n");
        
        // 1. removeIf(Predicate) - Removes elements matching condition
        System.out.println("1. removeIf() Method:");
        Collection<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        System.out.println("Before removeIf: " + numbers);
        
        // Remove all even numbers
        boolean removed = numbers.removeIf(n -> n % 2 == 0);
        System.out.println("Any elements removed? " + removed);
        System.out.println("After removing even numbers: " + numbers);
        
        // Remove numbers greater than 5
        numbers.removeIf(n -> n > 5);
        System.out.println("After removing numbers > 5: " + numbers);
        
        // 2. removeIf with custom predicate
        System.out.println("\n2. removeIf() with Custom Predicate:");
        Collection<String> words = new ArrayList<>();
        words.addAll(Arrays.asList("apple", "banana", "apricot", "cherry", 
                                   "avocado", "blueberry", "grape"));
        
        System.out.println("Before: " + words);
        
        // Create custom predicate
        Predicate<String> startsWithA = str -> str.startsWith("a");
        words.removeIf(startsWithA);
        System.out.println("After removing words starting with 'a': " + words);
        
        // Chain predicates
        Collection<String> words2 = new ArrayList<>();
        words2.addAll(Arrays.asList("short", "a", "medium", "verylongword", "ok"));
        System.out.println("\nBefore: " + words2);
        
        Predicate<String> tooShort = str -> str.length() < 3;
        Predicate<String> tooLong = str -> str.length() > 8;
        words2.removeIf(tooShort.or(tooLong));
        System.out.println("After removing too short or too long: " + words2);
        
        // 3. spliterator() - Creates Spliterator
        System.out.println("\n3. spliterator() Method:");
        Collection<String> cities = new ArrayList<>();
        cities.addAll(Arrays.asList("New York", "London", "Paris", "Tokyo", 
                                    "Sydney", "Mumbai", "Berlin"));
        
        Spliterator<String> spliterator = cities.spliterator();
        System.out.println("Spliterator class: " + spliterator.getClass().getSimpleName());
        System.out.println("Characteristics: " + spliterator.characteristics());
        System.out.println("Estimated size: " + spliterator.estimateSize());
        
        // Use spliterator to traverse
        System.out.println("\nTraversing with spliterator:");
        spliterator.forEachRemaining(city -> System.out.println("  - " + city));
        
        // 4. Splitting spliterator for parallel processing
        System.out.println("\n4. Splitting Spliterator:");
        Collection<Integer> bigList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            bigList.add(i);
        }
        
        Spliterator<Integer> spliterator1 = bigList.spliterator();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        
        System.out.println("Original spliterator size: " + spliterator1.estimateSize());
        System.out.println("Split spliterator size: " + 
                          (spliterator2 != null ? spliterator2.estimateSize() : "null"));
        
        System.out.println("\nFirst half:");
        if (spliterator2 != null) {
            spliterator2.forEachRemaining(n -> System.out.print(n + " "));
        }
        
        System.out.println("\n\nSecond half:");
        spliterator1.forEachRemaining(n -> System.out.print(n + " "));
        System.out.println();
    }
}
