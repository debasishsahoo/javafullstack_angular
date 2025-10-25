package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafety_Patterns {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST THREAD SAFETY & COMMON PATTERNS ===\n");

		demonstrateThreadSafety();
		demonstrateCommonPatterns();
	}

	// THREAD SAFETY
	public static void demonstrateThreadSafety() {
		System.out.println("\n--- THREAD SAFETY ---");

		System.out.println("Note: LinkedList is NOT thread-safe by default\n");

		// 1. Synchronized wrapper
		System.out.println("1. Using Collections.synchronizedList():");
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("A", "B", "C"));

		List<String> syncList = Collections.synchronizedList(list);
		System.out.println("   Synchronized list created: " + syncList);

		// Must synchronize when iterating
		System.out.println("   Iterating (must synchronize):");
		synchronized (syncList) {
			for (String item : syncList) {
				System.out.println("     " + item);
			}
		}

		// 2. CopyOnWriteArrayList (thread-safe alternative)
		System.out.println("\n2. Using CopyOnWriteArrayList:");
		CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
		cowList.addAll(Arrays.asList("X", "Y", "Z"));
		System.out.println("   CopyOnWriteArrayList: " + cowList);
		System.out.println("   • Thread-safe without explicit synchronization");
		System.out.println("   • Best for read-heavy scenarios");
		System.out.println("   • Writes are expensive (copies entire array)");

		// 3. ConcurrentLinkedQueue (for queue operations)
		System.out.println("\n3. Using ConcurrentLinkedQueue:");
		ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
		concurrentQueue.offer("First");
		concurrentQueue.offer("Second");
		concurrentQueue.offer("Third");
		System.out.println("   ConcurrentLinkedQueue: " + concurrentQueue);
		System.out.println("   • Non-blocking thread-safe queue");
		System.out.println("   • Ideal for producer-consumer scenarios");

		// 4. ConcurrentLinkedDeque
		System.out.println("\n4. Using ConcurrentLinkedDeque:");
		ConcurrentLinkedDeque<String> concurrentDeque = new ConcurrentLinkedDeque<>();
		concurrentDeque.addFirst("First");
		concurrentDeque.addLast("Last");
		System.out.println("   ConcurrentLinkedDeque: " + concurrentDeque);
		System.out.println("   • Thread-safe double-ended queue");

		// Thread safety guidelines
		System.out.println("\n--- Thread Safety Guidelines ---");
		System.out.println("• LinkedList is NOT thread-safe");
		System.out.println("• Use Collections.synchronizedList() for basic sync");
		System.out.println("• Use ConcurrentLinkedQueue for concurrent queue ops");
		System.out.println("• Use ConcurrentLinkedDeque for concurrent deque ops");
		System.out.println("• Always synchronize when iterating synchronized lists");
		System.out.println("• Consider CopyOnWriteArrayList for read-heavy scenarios");
	}

	// COMMON PATTERNS
	public static void demonstrateCommonPatterns() {
		System.out.println("\n--- COMMON PATTERNS ---");

		// 1. LRU Cache simulation
		System.out.println("\n1. LRU Cache pattern:");
		LinkedList<String> cache = new LinkedList<>();
		int maxSize = 3;

		String[] accesses = { "A", "B", "C", "A", "D" };
		for (String item : accesses) {
			cache.remove(item); // Remove if exists
			cache.addFirst(item); // Add to front (most recently used)

			if (cache.size() > maxSize) {
				cache.removeLast(); // Remove least recently used
			}

			System.out.println("   Access " + item + ": " + cache);
		}
		System.out.println("   Final cache (most recent first): " + cache);

		// 2. Sliding window
		System.out.println("\n2. Sliding window pattern:");
		LinkedList<Integer> window = new LinkedList<>();
		int windowSize = 3;
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };

		for (int num : data) {
			window.add(num);
			if (window.size() > windowSize) {
				window.removeFirst();
			}
			if (window.size() == windowSize) {
				int sum = window.stream().mapToInt(Integer::intValue).sum();
				double avg = sum / (double) windowSize;
				System.out.println("   Window: " + window + " | Sum: " + sum + " | Avg: " + avg);
			}
		}

		// 3. Undo/Redo functionality
		System.out.println("\n3. Undo/Redo stack pattern:");
		LinkedList<String> undoStack = new LinkedList<>();
		LinkedList<String> redoStack = new LinkedList<>();

		// Perform actions
		System.out.println("   Performing actions...");
		undoStack.push("Action1");
		undoStack.push("Action2");
		undoStack.push("Action3");
		System.out.println("   After actions: Undo=" + undoStack + ", Redo=" + redoStack);

		// Undo
		if (!undoStack.isEmpty()) {
			String action = undoStack.pop();
			redoStack.push(action);
			System.out.println("   After undo: Undo=" + undoStack + ", Redo=" + redoStack);
		}

		// Redo
		if (!redoStack.isEmpty()) {
			String action = redoStack.pop();
			undoStack.push(action);
			System.out.println("   After redo: Undo=" + undoStack + ", Redo=" + redoStack);
		}

		// 4. Task queue processing
		System.out.println("\n4. Task queue pattern:");
		LinkedList<String> taskQueue = new LinkedList<>();

		// Add tasks
		taskQueue.offer("Download file");
		taskQueue.offer("Process data");
		taskQueue.offer("Send notification");
		System.out.println("   Tasks queued: " + taskQueue);

		// Process tasks
		System.out.println("   Processing tasks:");
		while (!taskQueue.isEmpty()) {
			String task = taskQueue.poll();
			System.out.println("     ✓ " + task);
		}
		System.out.println("   All tasks completed!");

		// 5. Breadth-First Search structure
		System.out.println("\n5. BFS queue pattern (Binary Tree traversal):");
		LinkedList<Integer> bfsQueue = new LinkedList<>();

		bfsQueue.offer(1); // Root node
		System.out.println("   BFS Traversal:");
		while (!bfsQueue.isEmpty()) {
			int node = bfsQueue.poll();
			System.out.println("     Visit node: " + node);

			// Add children (left and right)
			if (node * 2 <= 8)
				bfsQueue.offer(node * 2); // Left child
			if (node * 2 + 1 <= 8)
				bfsQueue.offer(node * 2 + 1); // Right child
		}

		// 6. Recent items tracker
		System.out.println("\n6. Recent items tracker pattern:");
		LinkedList<String> recentItems = new LinkedList<>();
		int maxRecent = 5;

		String[] items = { "Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7" };
		for (String item : items) {
			recentItems.addFirst(item);
			if (recentItems.size() > maxRecent) {
				recentItems.removeLast();
			}
			System.out.println("   Added " + item + ": " + recentItems);
		}

		// 7. Circular buffer simulation
		System.out.println("\n7. Circular buffer pattern:");
		LinkedList<Integer> buffer = new LinkedList<>();
		int bufferSize = 4;

		for (int i = 1; i <= 10; i++) {
			buffer.addLast(i);
			if (buffer.size() > bufferSize) {
				buffer.removeFirst();
			}
			System.out.println("   Add " + i + ": " + buffer);
		}

		// 8. Palindrome checker
		System.out.println("\n8. Palindrome checker using Deque:");
		String[] words = { "radar", "hello", "level", "world", "madam" };

		for (String word : words) {
			LinkedList<Character> deque = new LinkedList<>();
			for (char c : word.toCharArray()) {
				deque.add(c);
			}

			boolean isPalindrome = true;
			while (deque.size() > 1) {
				if (!deque.pollFirst().equals(deque.pollLast())) {
					isPalindrome = false;
					break;
				}
			}
			System.out.println("   '" + word + "' is " + (isPalindrome ? "a palindrome" : "NOT a palindrome"));
		}
	}
}
