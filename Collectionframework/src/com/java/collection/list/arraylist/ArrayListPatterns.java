package com.java.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class ArrayListPatterns {
	public static void main(String[] args) {
		System.out.println("=== COMMON PATTERNS ===\n");

		// 1. STACK IMPLEMENTATION
		System.out.println("1. Stack Pattern:");
		ArrayList<String> stack = new ArrayList<>();

		// Push
		stack.add("First");
		stack.add("Second");
		stack.add("Third");
		System.out.println("   Stack: " + stack);

		// Peek
		if (!stack.isEmpty()) {
			System.out.println("   Peek: " + stack.get(stack.size() - 1));
		}

		// Pop
		if (!stack.isEmpty()) {
			String popped = stack.remove(stack.size() - 1);
			System.out.println("   Popped: " + popped);
			System.out.println("   After pop: " + stack);
		}

		// 2. REMOVING DUPLICATES
		System.out.println("\n2. Remove Duplicates:");
		ArrayList<Integer> dupes = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 3, 5, 1));
		System.out.println("   Original: " + dupes);

		ArrayList<Integer> unique = new ArrayList<>(new LinkedHashSet<>(dupes));
		System.out.println("   Unique: " + unique);

		// 3. FINDING COMMON ELEMENTS
		System.out.println("\n3. Common Elements:");
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("C", "D", "E", "F"));

		ArrayList<String> common = new ArrayList<>(list1);
		common.retainAll(list2);
		System.out.println("   List1: " + list1);
		System.out.println("   List2: " + list2);
		System.out.println("   Common: " + common);

		// 4. PAGINATION
		System.out.println("\n4. Pagination:");
		ArrayList<Integer> data = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			data.add(i);
		}

		int pageSize = 10;
		int pageNum = 2; // 0-indexed
		int from = pageNum * pageSize;
		int to = Math.min(from + pageSize, data.size());

		List<Integer> page = data.subList(from, to);
		System.out.println("   Page " + (pageNum + 1) + ": " + page);

		// 5. BATCH PROCESSING
		System.out.println("\n5. Batch Processing:");
		ArrayList<Integer> items = new ArrayList<>();
		for (int i = 1; i <= 25; i++) {
			items.add(i);
		}

		int batchSize = 5;
		System.out.println("   Processing in batches of " + batchSize + ":");
		for (int i = 0; i < items.size(); i += batchSize) {
			int end = Math.min(i + batchSize, items.size());
			List<Integer> batch = items.subList(i, end);
			System.out.println("   Batch: " + batch);
		}

		// 6. FREQUENCY COUNTING
		System.out.println("\n6. Frequency Counting:");
		ArrayList<String> words = new ArrayList<>(
				Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple"));

		Map<String, Integer> freq = new HashMap<>();
		for (String word : words) {
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}
		System.out.println("   Words: " + words);
		System.out.println("   Frequencies: " + freq);

		// 7. FILTERING AND COLLECTING
		System.out.println("\n7. Filter and Collect:");
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		ArrayList<Integer> evens = new ArrayList<>();
		for (Integer n : nums) {
			if (n % 2 == 0) {
				evens.add(n);
			}
		}
		System.out.println("   Original: " + nums);
		System.out.println("   Evens: " + evens);

		// 8. PARTITIONING
		System.out.println("\n8. Partitioning:");
		ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		ArrayList<Integer> lessThan5 = new ArrayList<>();
		ArrayList<Integer> greaterOrEqual5 = new ArrayList<>();

		for (Integer val : values) {
			if (val < 5) {
				lessThan5.add(val);
			} else {
				greaterOrEqual5.add(val);
			}
		}
		System.out.println("   Original: " + values);
		System.out.println("   < 5: " + lessThan5);
		System.out.println("   >= 5: " + greaterOrEqual5);

		// 9. FINDING MIN/MAX WITH CONDITION
		System.out.println("\n9. Conditional Min/Max:");
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 25, 3, 48, 7, 92, 15));

		Integer maxEven = null;
		for (Integer n : numbers) {
			if (n % 2 == 0) {
				if (maxEven == null || n > maxEven) {
					maxEven = n;
				}
			}
		}
		System.out.println("   Numbers: " + numbers);
		System.out.println("   Max even: " + maxEven);

		// 10. ROTATING ELEMENTS
		System.out.println("\n10. Manual Rotation:");
		ArrayList<String> rotate = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
		System.out.println("   Before: " + rotate);

		// Rotate right by 2
		int rotateBy = 2;
		for (int i = 0; i < rotateBy; i++) {
			rotate.add(0, rotate.remove(rotate.size() - 1));
		}
		System.out.println("   After rotate right by 2: " + rotate);
	}
}
