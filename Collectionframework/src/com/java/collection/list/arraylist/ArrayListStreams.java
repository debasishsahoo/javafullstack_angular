package com.java.collection.list.arraylist;

import java.util.*;
import java.util.stream.*;

public class ArrayListStreams {
	public static void main(String[] args) {
		System.out.println("=== STREAMS & LAMBDAS ===\n");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("Original: " + nums);

		// FILTER
		System.out.println("\n--- Filtering ---");
		System.out.println("Even numbers:");
		nums.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// MAP
		System.out.println("\n--- Mapping ---");
		ArrayList<Integer> squared = nums.stream().map(n -> n * n).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Squared: " + squared);

		// REDUCE
		System.out.println("\n--- Reducing ---");
		int sum = nums.stream().reduce(0, Integer::sum);
		System.out.println("Sum: " + sum);

		int product = nums.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Product: " + product);

		// MATCHING
		System.out.println("\n--- Matching ---");
		boolean hasEven = nums.stream().anyMatch(n -> n % 2 == 0);
		System.out.println("Has even: " + hasEven);

		boolean allPositive = nums.stream().allMatch(n -> n > 0);
		System.out.println("All positive: " + allPositive);

		boolean noneNegative = nums.stream().noneMatch(n -> n < 0);
		System.out.println("None negative: " + noneNegative);

		// COUNT
		System.out.println("\n--- Counting ---");
		long count = nums.stream().filter(n -> n > 5).count();
		System.out.println("Count > 5: " + count);

		// MIN AND MAX
		System.out.println("\n--- Min/Max ---");
		Optional<Integer> min = nums.stream().min(Integer::compareTo);
		Optional<Integer> max = nums.stream().max(Integer::compareTo);
		System.out.println("Min: " + min.orElse(0));
		System.out.println("Max: " + max.orElse(0));

		// DISTINCT
		System.out.println("\n--- Distinct ---");
		ArrayList<Integer> dupes = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4));
		System.out.println("With duplicates: " + dupes);

		ArrayList<Integer> unique = dupes.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Distinct: " + unique);

		// SORTED
		System.out.println("\n--- Sorting ---");
		ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
		System.out.println("Unsorted: " + unsorted);

		ArrayList<Integer> sorted = unsorted.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Sorted: " + sorted);

		// LIMIT AND SKIP
		System.out.println("\n--- Limit and Skip ---");
		System.out.print("First 3: ");
		nums.stream().limit(3).forEach(n -> System.out.print(n + " "));
		System.out.println();

		System.out.print("Skip first 5: ");
		nums.stream().skip(5).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// FLATMAP
		System.out.println("\n--- FlatMap ---");
		ArrayList<ArrayList<Integer>> nested = new ArrayList<>();
		nested.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
		nested.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
		nested.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

		System.out.println("Nested: " + nested);
		ArrayList<Integer> flat = nested.stream().flatMap(List::stream)
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Flattened: " + flat);

		// JOINING
		System.out.println("\n--- Joining ---");
		String joined = nums.stream().map(String::valueOf).collect(Collectors.joining(", "));
		System.out.println("Joined: " + joined);

		// GROUPING BY
		System.out.println("\n--- Grouping By ---");
		ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apricot", "cherry", "avocado"));

		Map<Character, List<String>> grouped = words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Grouped by first letter:");
		grouped.forEach((k, v) -> System.out.println("   " + k + ": " + v));

		// PARTITIONING BY
		System.out.println("\n--- Partitioning By ---");
		Map<Boolean, List<Integer>> partitioned = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("Even: " + partitioned.get(true));
		System.out.println("Odd: " + partitioned.get(false));

		// STATISTICS
		System.out.println("\n--- Statistics ---");
		IntSummaryStatistics stats = nums.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("Count: " + stats.getCount());
		System.out.println("Sum: " + stats.getSum());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Max: " + stats.getMax());
		System.out.println("Average: " + stats.getAverage());
	}
}
