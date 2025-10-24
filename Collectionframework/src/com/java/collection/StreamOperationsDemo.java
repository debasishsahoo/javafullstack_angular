package com.java.collection;

import java.util.*;
import java.util.stream.*;

public class StreamOperationsDemo {
    public static void main(String[] args) {
        System.out.println("=== STREAM OPERATIONS DEMO ===\n");
        
        Collection<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        System.out.println("Original Collection: " + numbers);
        
        // 1. stream() - Creates sequential stream
        System.out.println("\n1. stream() Method:");
        Stream<Integer> stream1 = numbers.stream();
        System.out.println("Stream class: " + stream1.getClass().getName());
        
        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                          .filter(n -> n % 2 == 0)
                                          .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Map to squares
        List<Integer> squares = numbers.stream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
        
        // Sum using reduce
        int sum = numbers.stream()
                        .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // 2. parallelStream() - Creates parallel stream
        System.out.println("\n2. parallelStream() Method:");
        Stream<Integer> parallelStream = numbers.stream().parallel();
        System.out.println("Is parallel? " + parallelStream.isParallel());
        
        // Process in parallel
        System.out.println("\nParallel processing demonstration:");
        long startTime = System.nanoTime();
        int parallelSum = numbers.parallelStream()
                                .map(n -> {
                                    // Simulate heavy computation
                                    return n * 2;
                                })
                                .reduce(0, Integer::sum);
        long endTime = System.nanoTime();
        System.out.println("Parallel sum of doubled values: " + parallelSum);
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        
        // 3. Various stream operations
        System.out.println("\n3. Complex Stream Operations:");
        
        Collection<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Alice", "Bob", "Charlie", "David", 
                                   "Eve", "Frank", "Grace", "Henry"));
        
        System.out.println("Names: " + names);
        
        // Count names starting with vowels
        long vowelCount = names.stream()
                              .filter(name -> "AEIOUaeiou".indexOf(name.charAt(0)) != -1)
                              .count();
        System.out.println("Names starting with vowels: " + vowelCount);
        
        // Get names sorted by length
        List<String> sortedByLength = names.stream()
                                          .sorted(Comparator.comparing(String::length))
                                          .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);
        
        // Find first name longer than 5 characters
        Optional<String> longName = names.stream()
                                        .filter(name -> name.length() > 5)
                                        .findFirst();
        System.out.println("First name > 5 chars: " + longName.orElse("None"));
        
        // Group by first letter
        Map<Character, List<String>> groupedByFirstLetter = 
            names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Grouped by first letter: " + groupedByFirstLetter);
    }
}