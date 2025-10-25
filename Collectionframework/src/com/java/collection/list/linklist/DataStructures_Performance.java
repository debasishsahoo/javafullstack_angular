package com.java.collection.list.linklist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class DataStructures_Performance {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST AS DATA STRUCTURES & PERFORMANCE ===\n");

		demonstrateAsDataStructures();
		demonstratePerformanceComparison();
	}

	// Helper class for priority queue demo
	static class Task {
		String name;
		int priority;

		Task(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return name + "(P" + priority + ")";
		}
	}

	// LINKEDLIST AS DIFFERENT DATA STRUCTURES
	public static void demonstrateAsDataStructures() {
		System.out.println("\n--- LINKEDLIST AS DIFFERENT DATA STRUCTURES ---");

		// 1. As a Stack (LIFO)
		System.out.println("\n1. LinkedList as Stack (LIFO):");
		LinkedList<String> stack = new LinkedList<>();

		stack.push("Bottom");
		stack.push("Middle");
		stack.push("Top");
		System.out.println("   Stack: " + stack);
		System.out.println("   Pop: " + stack.pop() + " (removed)");
		System.out.println("   Peek: " + stack.peek() + " (still there)");
		System.out.println("   Stack now: " + stack);

		// 2. As a Queue (FIFO)
		System.out.println("\n2. LinkedList as Queue (FIFO):");
		LinkedList<String> queue = new LinkedList<>();

		queue.offer("First");
		queue.offer("Second");
		queue.offer("Third");
		System.out.println("   Queue: " + queue);
		System.out.println("   Poll: " + queue.poll() + " (removed)");
		System.out.println("   Peek: " + queue.peek() + " (still there)");
		System.out.println("   Queue now: " + queue);

		// 3. As a Deque (Double-ended queue)
		System.out.println("\n3. LinkedList as Deque:");
		LinkedList<Integer> deque = new LinkedList<>();

		deque.offerFirst(2);
		deque.offerFirst(1);
		deque.offerLast(3);
		deque.offerLast(4);
		System.out.println("   Deque: " + deque);
		System.out.println("   Poll first: " + deque.pollFirst());
		System.out.println("   Poll last: " + deque.pollLast());
		System.out.println("   Deque now: " + deque);

		// 4. As a List
		System.out.println("\n4. LinkedList as List:");
		LinkedList<String> list = new LinkedList<>();

		list.add("Element 1");
		list.add(0, "Element 0");
		list.add("Element 2");
		System.out.println("   List: " + list);
		System.out.println("   Get(1): " + list.get(1));
		list.set(1, "Modified");
		System.out.println("   After set(1): " + list);

		// 5. Priority Queue simulation
		System.out.println("\n5. Priority processing simulation:");
		LinkedList<Task> tasks = new LinkedList<>();

		tasks.add(new Task("Low priority", 1));
		tasks.add(new Task("High priority", 3));
		tasks.add(new Task("Medium priority", 2));

		System.out.println("   Unsorted: " + tasks);
		tasks.sort(Comparator.comparingInt(t -> -t.priority)); // Sort by priority descending
		System.out.println("   Sorted by priority: " + tasks);

		System.out.println("   Processing:");
		while (!tasks.isEmpty()) {
			System.out.println("     " + tasks.poll());
		}
	}

	// PERFORMANCE COMPARISON
	public static void demonstratePerformanceComparison() {
		System.out.println("\n--- PERFORMANCE COMPARISON ---");

		int size = 10000;

		// 1. Add operations
		System.out.println("\n1. ADD OPERATIONS (10,000 elements):");

		// LinkedList - add at end
		LinkedList<Integer> linkedList = new LinkedList<>();
		long start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			linkedList.add(i);
		}
		long linkedAddEnd = System.nanoTime() - start;

		// ArrayList - add at end
		ArrayList<Integer> arrayList = new ArrayList<>();
		start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			arrayList.add(i);
		}
		long arrayAddEnd = System.nanoTime() - start;

		System.out.println("   LinkedList add(end): " + linkedAddEnd / 1000 + " μs");
		System.out.println("   ArrayList add(end):  " + arrayAddEnd / 1000 + " μs");
		System.out.println("   Winner: " + (linkedAddEnd < arrayAddEnd ? "LinkedList" : "ArrayList"));

		// Add at beginning
		linkedList.clear();
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			linkedList.addFirst(i);
		}
		long linkedAddFirst = System.nanoTime() - start;

		arrayList.clear();
		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			arrayList.add(0, i);
		}
		long arrayAddFirst = System.nanoTime() - start;

		System.out.println("\n   LinkedList add(0): " + linkedAddFirst / 1000 + " μs");
		System.out.println("   ArrayList add(0):  " + arrayAddFirst / 1000 + " μs");
		System.out.println("   Winner: LinkedList (much faster!)");

		// 2. Get operations
		System.out.println("\n2. RANDOM ACCESS (get operations):");

		linkedList.clear();
		arrayList.clear();
		for (int i = 0; i < size; i++) {
			linkedList.add(i);
			arrayList.add(i);
		}

		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			linkedList.get(i);
		}
		long linkedGet = System.nanoTime() - start;

		start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			arrayList.get(i);
		}
		long arrayGet = System.nanoTime() - start;

		System.out.println("   LinkedList get(): " + linkedGet / 1000 + " μs");
		System.out.println("   ArrayList get():  " + arrayGet / 1000 + " μs");
		System.out.println("   Winner: ArrayList (much faster!)");

		// 3. Iteration
		System.out.println("\n3. ITERATION:");

		start = System.nanoTime();
		for (Integer num : linkedList) {
			int x = num; // Just access
		}
		long linkedIter = System.nanoTime() - start;

		start = System.nanoTime();
		for (Integer num : arrayList) {
			int x = num; // Just access
		}
		long arrayIter = System.nanoTime() - start;

		System.out.println("   LinkedList iterator: " + linkedIter / 1000 + " μs");
		System.out.println("   ArrayList iterator:  " + arrayIter / 1000 + " μs");
		System.out.println("   Winner: " + (linkedIter < arrayIter ? "LinkedList" : "ArrayList"));

		// 4. Remove operations
		System.out.println("\n4. REMOVE OPERATIONS:");

		LinkedList<Integer> llRemove = new LinkedList<>(linkedList);
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			llRemove.removeFirst();
		}
		long linkedRemove = System.nanoTime() - start;

		ArrayList<Integer> alRemove = new ArrayList<>(arrayList);
		start = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			alRemove.remove(0);
		}
		long arrayRemove = System.nanoTime() - start;

		System.out.println("   LinkedList remove(0): " + linkedRemove / 1000 + " μs");
		System.out.println("   ArrayList remove(0):  " + arrayRemove / 1000 + " μs");
		System.out.println("   Winner: LinkedList (much faster!)");

		// Summary
		System.out.println("\n--- PERFORMANCE SUMMARY ---");
		System.out.println("LinkedList is better for:");
		System.out.println("  • Frequent insertions/deletions at beginning/middle");
		System.out.println("  • Queue/Deque operations");
		System.out.println("  • When you don't need random access");
		System.out.println("\nArrayList is better for:");
		System.out.println("  • Random access (get/set by index)");
		System.out.println("  • Memory efficiency");
		System.out.println("  • Iteration and adding at end");
		System.out.println("  • Most general-purpose use cases");
	}
}
