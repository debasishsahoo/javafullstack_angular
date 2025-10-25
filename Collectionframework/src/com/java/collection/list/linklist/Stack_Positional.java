package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Stack_Positional {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST STACK & POSITIONAL ACCESS ===\n");

		demonstrateStackOperations();
		demonstratePositionalAccess();
	}

	// STACK OPERATIONS
	public static void demonstrateStackOperations() {
		System.out.println("\n--- STACK OPERATIONS ---");

		LinkedList<String> stack = new LinkedList<>();

		// push(E element) - adds to the top (beginning)
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		System.out.println("After push operations: " + stack);
		System.out.println("Top element: " + stack.peek());

		// pop() - removes and returns top element
		String popped = stack.pop();
		System.out.println("\npop(): " + popped);
		System.out.println("Stack after pop: " + stack);

		// peek() - retrieves top without removing
		String top = stack.peek();
		System.out.println("\npeek(): " + top);
		System.out.println("Stack unchanged: " + stack);

		// Demonstrating LIFO behavior
		System.out.println("\n--- LIFO Demonstration ---");
		LinkedList<Integer> lifoStack = new LinkedList<>();

		System.out.println("Pushing: 1, 2, 3, 4, 5");
		for (int i = 1; i <= 5; i++) {
			lifoStack.push(i);
		}

		System.out.println("Popping all elements:");
		while (!lifoStack.isEmpty()) {
			System.out.println("  Popped: " + lifoStack.pop());
		}
	}

	// POSITIONAL ACCESS
	public static void demonstratePositionalAccess() {
		System.out.println("\n--- POSITIONAL ACCESS ---");

		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("A", "B", "C", "D", "E"));
		System.out.println("Initial list: " + list);

		// get(int index)
		System.out.println("\nget(0): " + list.get(0));
		System.out.println("get(2): " + list.get(2));
		System.out.println("get(4): " + list.get(4));

		// set(int index, E element)
		String oldValue = list.set(2, "NEW_C");
		System.out.println("\nset(2, 'NEW_C'): old=" + oldValue);
		System.out.println("Updated list: " + list);

		// add(int index, E element)
		list.add(1, "INSERTED");
		System.out.println("\nadd(1, 'INSERTED'): " + list);

		// remove(int index)
		String removed = list.remove(3);
		System.out.println("\nremove(3): removed=" + removed);
		System.out.println("After removal: " + list);

		// indexOf(Object o)
		int index1 = list.indexOf("B");
		System.out.println("\nindexOf('B'): " + index1);

		// lastIndexOf(Object o)
		list.add("B"); // Add duplicate
		System.out.println("List with duplicate: " + list);
		int index2 = list.lastIndexOf("B");
		System.out.println("lastIndexOf('B'): " + index2);

		// subList(int fromIndex, int toIndex)
		List<String> sublist = list.subList(1, 4);
		System.out.println("\nsubList(1, 4): " + sublist);
		System.out.println("Note: This is a view, not a copy");

		// Performance warning
		System.out.println("\n--- Performance Note ---");
		System.out.println("get(index) is O(n) in LinkedList!");
		System.out.println("For random access, use ArrayList instead");
	}
}
