package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Cloning_Advanced {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST CLONING & ADVANCED OPERATIONS ===\n");

		demonstrateCloningOperations();
		demonstrateAdvancedOperations();

	}

	// CLONING AND COPYING
	public static void demonstrateCloningOperations() {
		System.out.println("\n--- CLONING AND COPYING ---");

		LinkedList<String> original = new LinkedList<>();
		original.addAll(Arrays.asList("A", "B", "C", "D"));
		System.out.println("Original list: " + original);

		// 1. clone() method - shallow copy
		@SuppressWarnings("unchecked")
		LinkedList<String> cloned = (LinkedList<String>) original.clone();
		System.out.println("\n1. Cloned list: " + cloned);

		cloned.add("E");
		System.out.println("   After modifying clone: " + cloned);
		System.out.println("   Original unchanged: " + original);

		// 2. Copy constructor
		LinkedList<String> copied = new LinkedList<>(original);
		System.out.println("\n2. Copy constructor: " + copied);

		// 3. addAll() method
		LinkedList<String> copied2 = new LinkedList<>();
		copied2.addAll(original);
		System.out.println("3. Using addAll(): " + copied2);

		// 4. Stream copy
		LinkedList<String> streamCopy = original.stream().collect(Collectors.toCollection(LinkedList::new));
		System.out.println("\n4. Stream copy: " + streamCopy);

		// 5. Manual iteration copy
		LinkedList<String> manualCopy = new LinkedList<>();
		for (String item : original) {
			manualCopy.add(item);
		}
		System.out.println("5. Manual copy: " + manualCopy);

		// Deep copy demonstration (for mutable objects)
		System.out.println("\n--- Deep Copy Example ---");
		LinkedList<StringBuilder> mutableList = new LinkedList<>();
		mutableList.add(new StringBuilder("First"));
		mutableList.add(new StringBuilder("Second"));

		// Shallow copy - references same objects
		@SuppressWarnings("unchecked")
		LinkedList<StringBuilder> shallowCopy = (LinkedList<StringBuilder>) mutableList.clone();

		// Deep copy - creates new objects
		LinkedList<StringBuilder> deepCopy = new LinkedList<>();
		for (StringBuilder sb : mutableList) {
			deepCopy.add(new StringBuilder(sb));
		}

		mutableList.get(0).append("-Modified");
		System.out.println("After modifying original:");
		System.out.println("  Original: " + mutableList);
		System.out.println("  Shallow copy (affected): " + shallowCopy);
		System.out.println("  Deep copy (unaffected): " + deepCopy);
	}

	// ADVANCED OPERATIONS
	public static void demonstrateAdvancedOperations() {
		System.out.println("\n--- ADVANCED OPERATIONS ---");

		// 1. Spliterator
		System.out.println("1. Spliterator:");
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

		Spliterator<Integer> spliterator = numbers.spliterator();
		System.out.println("   Estimated size: " + spliterator.estimateSize());
		System.out.println("   First few elements:");
		spliterator.tryAdvance(n -> System.out.println("     " + n));
		spliterator.tryAdvance(n -> System.out.println("     " + n));

		// 2. Parallel stream
		System.out.println("\n2. Parallel stream processing:");
		LinkedList<Integer> nums = new LinkedList<>();
		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}

		int sum = nums.parallelStream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("   Sum of even numbers (1-100): " + sum);

		// 3. ListIterator modifications
		System.out.println("\n3. ListIterator modifications:");
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("A", "B", "C", "D"));
		System.out.println("   Original: " + list);

		ListIterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			String current = iter.next();
			if (current.equals("B")) {
				iter.set("MODIFIED_B"); // Replace
			} else if (current.equals("C")) {
				iter.remove(); // Remove
			}
		}
		System.out.println("   After modifications: " + list);

		// 4. Custom sorting with Comparator
		System.out.println("\n4. Custom sorting:");
		LinkedList<String> fruits = new LinkedList<>();
		fruits.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"));

		System.out.println("   Original: " + fruits);
		fruits.sort(Comparator.comparingInt(String::length));
		System.out.println("   By length: " + fruits);

		fruits.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
		System.out.println("   By length, then alphabetically: " + fruits);

		// 5. Stream operations
		System.out.println("\n5. Stream operations:");
		LinkedList<Integer> data = new LinkedList<>();
		data.addAll(Arrays.asList(10, 20, 30, 40, 50));

		// Map and filter
		List<Integer> transformed = data.stream().map(n -> n * 2).filter(n -> n > 50).collect(Collectors.toList());
		System.out.println("   Doubled and filtered (>50): " + transformed);

		// Reduce
		int product = data.stream().reduce(1, (a, b) -> a * b);
		System.out.println("   Product: " + product);

		// Statistics
		IntSummaryStatistics stats = data.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("   Statistics: " + stats);

		// 6. Grouping and partitioning
		System.out.println("\n6. Grouping:");
		LinkedList<String> words = new LinkedList<>();
		words.addAll(Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry"));

		Map<Character, List<String>> grouped = words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("   Grouped by first letter: " + grouped);

		Map<Boolean, List<String>> partitioned = words.stream().collect(Collectors.partitioningBy(s -> s.length() > 6));
		System.out.println("   Partitioned by length>6: " + partitioned);

		// 7. Finding elements
		System.out.println("\n7. Finding elements:");
		Optional<String> first = words.stream().filter(s -> s.startsWith("b")).findFirst();
		System.out.println("   First starting with 'b': " + first.orElse("none"));

		Optional<String> any = words.stream().filter(s -> s.length() > 7).findAny();
		System.out.println("   Any with length>7: " + any.orElse("none"));

		// 8. Matching
		System.out.println("\n8. Matching:");
		boolean allLong = words.stream().allMatch(s -> s.length() > 3);
		System.out.println("   All length > 3: " + allLong);

		boolean anyLong = words.stream().anyMatch(s -> s.length() > 8);
		System.out.println("   Any length > 8: " + anyLong);

		boolean noneEmpty = words.stream().noneMatch(String::isEmpty);
		System.out.println("   None empty: " + noneEmpty);
	}
}
