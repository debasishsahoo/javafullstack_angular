package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommonMistakes_BestPractices {

	public static void main(String[] args) {
		System.out.println("=== AVOIDING COMMON MISTAKES & BEST PRACTICES ===\n");

		demonstrateCommonMistakes();
		demonstrateBestPractices();

	}

	// AVOIDING COMMON MISTAKES
	public static void demonstrateCommonMistakes() {
		System.out.println("\n--- COMMON MISTAKES TO AVOID ---");

		// Mistake 1: Using get() in loop (O(n²))
		System.out.println("\n1. MISTAKE: Using get() in loop");
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}

		System.out.println("   [WRONG] WRONG (O(n²) - very slow):");
		System.out.println("   for (int i = 0; i < list.size(); i++) {");
		System.out.println("       int value = list.get(i); // Traverses from start each time!");
		System.out.println("   }");

		long start = System.nanoTime();
		int sum1 = 0;
		for (int i = 0; i < list.size(); i++) {
			sum1 += list.get(i);
		}
		long wrongTime = System.nanoTime() - start;

		System.out.println("\n   [CORRECT] CORRECT (O(n) - fast):");
		System.out.println("   for (Integer num : list) {");
		System.out.println("       int value = num; // Uses iterator");
		System.out.println("   }");

		start = System.nanoTime();
		int sum2 = 0;
		for (Integer num : list) {
			sum2 += num;
		}
		long correctTime = System.nanoTime() - start;

		System.out.println("\n   Performance comparison:");
		System.out.println("   Wrong approach: " + wrongTime / 1000 + " μs");
		System.out.println("   Correct approach: " + correctTime / 1000 + " μs");
		System.out.println("   Speedup: " + (wrongTime / correctTime) + "x faster!");

		// Mistake 2: ConcurrentModificationException
		System.out.println("\n2. MISTAKE: Modifying list during iteration");
		LinkedList<Integer> nums = new LinkedList<>();
		nums.addAll(Arrays.asList(1, 2, 3, 4, 5));

		System.out.println("   [WRONG] WRONG:");
		System.out.println("   for (Integer num : nums) {");
		System.out.println("       if (num % 2 == 0) {");
		System.out.println("           nums.remove(num); // Throws exception!");
		System.out.println("       }");
		System.out.println("   }");

		try {
			for (Integer num : nums) {
				if (num % 2 == 0) {
					nums.remove(num);
				}
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("   Exception thrown: " + e.getClass().getSimpleName());
		}

		System.out.println("\n   [CORRECT] CORRECT:");
		System.out.println("   Iterator<Integer> iter = nums.iterator();");
		System.out.println("   while (iter.hasNext()) {");
		System.out.println("       if (iter.next() % 2 == 0) {");
		System.out.println("           iter.remove(); // Safe removal");
		System.out.println("       }");
		System.out.println("   }");

		nums.clear();
		nums.addAll(Arrays.asList(1, 2, 3, 4, 5));
		Iterator<Integer> iter = nums.iterator();
		while (iter.hasNext()) {
			if (iter.next() % 2 == 0) {
				iter.remove();
			}
		}
		System.out.println("   Result: " + nums + " (evens removed)");

		// Mistake 3: Using LinkedList when ArrayList is better
		System.out.println("\n3. MISTAKE: Choosing wrong collection type");
		System.out.println("\n   [WRONG] Use LinkedList when you need:");
		System.out.println("   • Frequent random access → Use ArrayList instead!");
		System.out.println("   • Memory efficiency → Use ArrayList instead!");
		System.out.println("   • Only adding at end → Use ArrayList instead!");

		System.out.println("\n   [CORRECT] Use LinkedList when you need:");
		System.out.println("   • Frequent insertions/deletions at beginning/middle");
		System.out.println("   • Queue/Deque operations");
		System.out.println("   • No random access required");
		System.out.println("   • Don't know size in advance");

		// Mistake 4: Not using descendingIterator
		System.out.println("\n4. MISTAKE: Inefficient reverse iteration");
		LinkedList<String> items = new LinkedList<>();
		items.addAll(Arrays.asList("A", "B", "C", "D"));

		System.out.println("   [WRONG] WRONG (O(n²)):");
		System.out.println("   for (int i = items.size() - 1; i >= 0; i--) {");
		System.out.println("       System.out.println(items.get(i)); // O(n) each!");
		System.out.println("   }");

		System.out.println("\n   [CORRECT] CORRECT (O(n)):");
		System.out.println("   Iterator<String> iter = items.descendingIterator();");
		System.out.println("   while (iter.hasNext()) {");
		System.out.println("       System.out.println(iter.next());");
		System.out.println("   }");

		System.out.println("\n   Result:");
		Iterator<String> descIter = items.descendingIterator();
		while (descIter.hasNext()) {
			System.out.println("     " + descIter.next());
		}

		// Mistake 5: Forgetting null checks
		System.out.println("\n5. MISTAKE: Not handling null elements");
		LinkedList<String> withNull = new LinkedList<>();
		withNull.add("First");
		withNull.add(null);
		withNull.add("Third");

		System.out.println("   [WRONG] WRONG (may throw NullPointerException):");
		System.out.println("   for (String s : withNull) {");
		System.out.println("       System.out.println(s.length()); // Crashes on null!");
		System.out.println("   }");

		try {
			for (String s : withNull) {
				System.out.println("     Length: " + s.length());
			}
		} catch (NullPointerException e) {
			System.out.println("   NullPointerException thrown!");
		}

		System.out.println("\n   [CORRECT] CORRECT:");
		System.out.println("   for (String s : withNull) {");
		System.out.println("       if (s != null) {");
		System.out.println("           System.out.println(s.length());");
		System.out.println("       }");
		System.out.println("   }");

		System.out.println("\n   Result:");
		for (String s : withNull) {
			if (s != null) {
				System.out.println("     Length of '" + s + "': " + s.length());
			} else {
				System.out.println("     Null element (skipped)");
			}
		}

		// Mistake 6: Not clearing references
		System.out.println("\n6. MISTAKE: Memory leak from unreleased references");
		System.out.println("   [WRONG] WRONG:");
		System.out.println("   LinkedList<LargeObject> list = new LinkedList<>();");
		System.out.println("   // ... add many large objects");
		System.out.println("   list = new LinkedList<>(); // Old list still in memory!");

		System.out.println("\n   [CORRECT] CORRECT:");
		System.out.println("   list.clear(); // Explicitly clear first");
		System.out.println("   list = new LinkedList<>();");

		// Mistake 7: Using size() in loop condition
		System.out.println("\n7. MISTAKE: Calling size() repeatedly in loop");
		System.out.println("   [WRONG] LESS EFFICIENT:");
		System.out.println("   for (int i = 0; i < list.size(); i++) {");
		System.out.println("       // size() called every iteration");
		System.out.println("   }");

		System.out.println("\n   [CORRECT] MORE EFFICIENT:");
		System.out.println("   int size = list.size();");
		System.out.println("   for (int i = 0; i < size; i++) {");
		System.out.println("       // size() called once");
		System.out.println("   }");
		System.out.println("\n   Or better yet, use iterator or for-each loop!");

	}

	// BEST PRACTICES
	public static void demonstrateBestPractices() {
		System.out.println("\n--- BEST PRACTICES ---");

		// 1. Use appropriate methods
		System.out.println("\n1. Use appropriate methods for your use case:");
		LinkedList<String> list = new LinkedList<>();

		System.out.println("   For Queue (FIFO):");
		System.out.println("   [CORRECT] offer(), poll(), peek()");

		System.out.println("\n   For Stack (LIFO):");
		System.out.println("   [CORRECT] push(), pop(), peek()");

		System.out.println("\n   For Deque:");
		System.out.println("   [CORRECT] addFirst(), addLast(), removeFirst(), removeLast()");

		// 2. Use iterators for traversal
		System.out.println("\n2. Always use iterators or for-each for traversal:");
		list.addAll(Arrays.asList("A", "B", "C"));

		System.out.println("   [CORRECT] Preferred:");
		for (String item : list) {
			System.out.println("     " + item);
		}

		// 3. Check for empty before operations
		System.out.println("\n3. Check for empty before peek/poll/pop:");
		LinkedList<Integer> queue = new LinkedList<>();

		System.out.println("   [CORRECT] Good practice:");
		if (!queue.isEmpty()) {
			Integer value = queue.poll();
			System.out.println("     Polled: " + value);
		} else {
			System.out.println("     Queue is empty, nothing to poll");
		}

		// 4. Use specific collection interfaces
		System.out.println("\n4. Program to interfaces, not implementations:");
		System.out.println("   [CORRECT] Good:");
		System.out.println("   List<String> list = new LinkedList<>();");
		System.out.println("   Queue<String> queue = new LinkedList<>();");
		System.out.println("   Deque<String> deque = new LinkedList<>();");

		System.out.println("\n   [WRONG] Less flexible:");
		System.out.println("   LinkedList<String> list = new LinkedList<>();");

		// 5. Consider capacity for ArrayList
		System.out.println("\n5. For ArrayList alternative, consider initial capacity:");
		System.out.println("   ArrayList<String> al = new ArrayList<>(1000);");
		System.out.println("   (LinkedList doesn't need capacity - it grows dynamically)");

		// 6. Thread safety
		System.out.println("\n6. Make thread-safe if needed:");
		System.out.println("   List<String> syncList = Collections.synchronizedList(list);");
		System.out.println("   Or use: ConcurrentLinkedQueue / ConcurrentLinkedDeque");

		// 7. Use streams wisely
		System.out.println("\n7. Use streams for complex operations:");
		list.clear();
		list.addAll(Arrays.asList("apple", "banana", "apricot", "cherry"));

		List<String> filtered = list.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).toList();
		System.out.println("   Filtered and transformed: " + filtered);

		// 8. Defensive copying
		System.out.println("\n8. Use defensive copying when needed:");
		System.out.println("   [CORRECT] Return copy: return new LinkedList<>(internalList);");
		System.out.println("   [CORRECT] Accept copy: this.list = new LinkedList<>(parameter);");

		// Summary
		System.out.println("\n--- QUICK REFERENCE ---");
		System.out.println("[CORRECT] DO:");
		System.out.println("  • Use iterators for traversal");
		System.out.println("  • Choose ArrayList unless you need LinkedList features");
		System.out.println("  • Use offer/poll for queues, push/pop for stacks");
		System.out.println("  • Check isEmpty() before operations that can throw");
		System.out.println("  • Use descendingIterator() for reverse iteration");
		System.out.println("\n[WRONG] DON'T:");
		System.out.println("  • Use get(i) in loops (O(n²) performance)");
		System.out.println("  • Modify list during for-each iteration");
		System.out.println("  • Use LinkedList for random access");
		System.out.println("  • Forget null checks when needed");
		System.out.println("  • Ignore thread safety in concurrent scenarios");
	}
}