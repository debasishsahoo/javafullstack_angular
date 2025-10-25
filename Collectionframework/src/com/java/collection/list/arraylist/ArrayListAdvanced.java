package com.java.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListAdvanced {
	public static void main(String[] args) {
		System.out.println("=== ADVANCED OPERATIONS ===\n");

		// 1. UNMODIFIABLE LISTS
		System.out.println("--- Unmodifiable Lists ---");

		ArrayList<String> original = new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> unmod = Collections.unmodifiableList(original);
		System.out.println("Unmodifiable: " + unmod);

		try {
			unmod.add("D");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify: " + e.getClass().getSimpleName());
		}

		// Changes to original affect unmodifiable view
		original.add("D");
		System.out.println("After adding to original: " + unmod);

		// 2. SINGLETON AND EMPTY LISTS
		System.out.println("\n--- Singleton and Empty Lists ---");

		List<String> singleton = Collections.singletonList("Only");
		System.out.println("Singleton: " + singleton);

		List<String> empty = Collections.emptyList();
		System.out.println("Empty: " + empty + ", isEmpty: " + empty.isEmpty());

		// 3. N COPIES
		System.out.println("\n--- Creating N Copies ---");

		ArrayList<String> repeated = new ArrayList<>(Collections.nCopies(5, "Hello"));
		System.out.println("5 copies: " + repeated);

		// 4. REPLACE ALL OCCURRENCES
		System.out.println("\n--- Replace All Occurrences ---");

		ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A"));
		System.out.println("Original: " + list);
		Collections.replaceAll(list, "A", "X");
		System.out.println("After replaceAll('A', 'X'): " + list);

		// 5. REVERSING PORTION
		System.out.println("\n--- Reverse Portion ---");

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		System.out.println("Original: " + nums);
		Collections.reverse(nums.subList(2, 6));
		System.out.println("After reversing [2,6): " + nums);

		// 6. SYNCHRONIZED LIST
		System.out.println("\n--- Thread-Safe Lists ---");

		ArrayList<Integer> unsafe = new ArrayList<>();
		List<Integer> safe = Collections.synchronizedList(unsafe);
		System.out.println("Created synchronized list");

		synchronized (safe) {
			safe.add(1);
			safe.add(2);
			safe.add(3);
			System.out.println("Synchronized: " + safe);
		}

		// CopyOnWriteArrayList
		CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
		cowList.add("A");
		cowList.add("B");
		System.out.println("CopyOnWriteArrayList: " + cowList);
		System.out.println("(Thread-safe, good for read-heavy operations)");

		// 7. LIST EQUALITY WITH DIFFERENT TYPES
		System.out.println("\n--- List Equality ---");

		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
		LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3));

		System.out.println("ArrayList: " + arrayList);
		System.out.println("LinkedList: " + linkedList);
		System.out.println("Are equal: " + arrayList.equals(linkedList));

		// 8. CUSTOM SORTING
		System.out.println("\n--- Custom Sorting ---");

		ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "bob", "Charlie", "david"));
		System.out.println("Original: " + names);

		// Case-insensitive sort
		names.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println("Case-insensitive: " + names);

		// Custom comparator - reverse length
		names.sort((a, b) -> Integer.compare(b.length(), a.length()));
		System.out.println("By length (desc): " + names);

		// 9. CONDITIONAL OPERATIONS
		System.out.println("\n--- Conditional Operations ---");

		ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		// Check if any element matches
		boolean hasLarge = values.stream().anyMatch(n -> n > 8);
		System.out.println("Has element > 8: " + hasLarge);

		// Check if all match
		boolean allPositive = values.stream().allMatch(n -> n > 0);
		System.out.println("All positive: " + allPositive);

		// Find first matching
		Optional<Integer> first = values.stream().filter(n -> n > 5).findFirst();
		System.out.println("First > 5: " + first.orElse(null));

		// 10. NESTED LISTS
		System.out.println("\n--- Nested Lists ---");

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
		matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
		matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

		System.out.println("2D ArrayList:");
		for (ArrayList<Integer> row : matrix) {
			System.out.println("   " + row);
		}

		// Access element
		int element = matrix.get(1).get(2); // Row 1, Col 2
		System.out.println("Element [1][2]: " + element);

		// 11. BULK CONDITIONAL REMOVAL
		System.out.println("\n--- Bulk Conditional Removal ---");

		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("Original: " + numbers);

		numbers.removeIf(n -> n % 2 == 0 || n > 7);
		System.out.println("After removeIf (even or > 7): " + numbers);

		// 12. CHAINING OPERATIONS
		System.out.println("\n--- Chaining Operations ---");

		ArrayList<Integer> chain = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7));

		ArrayList<Integer> result = chain.stream().filter(n -> n > 2).map(n -> n * 2).sorted().collect(ArrayList::new,
				ArrayList::add, ArrayList::addAll);

		System.out.println("Original: " + chain);
		System.out.println("Filtered > 2, doubled, sorted: " + result);

		// 13. FREQUENCY ANALYSIS
		System.out.println("\n--- Frequency Analysis ---");

		ArrayList<String> words = new ArrayList<>(
				Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple"));

		String mostFrequent = null;
		int maxCount = 0;

		Set<String> unique = new HashSet<>(words);
		for (String word : unique) {
			int count = Collections.frequency(words, word);
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = word;
			}
		}

		System.out.println("Words: " + words);
		System.out.println("Most frequent: '" + mostFrequent + "' (" + maxCount + " times)");
	}
}