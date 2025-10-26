package com.java.collection.list.vector.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class CompleteStackReference {
	public static void main(String[] args) {
		System.out.println("COMPLETE JAVA STACK CLASS REFERENCE");

		// Creating stack
		Stack<String> stack = new Stack<>();
		System.out.println("1. Created empty stack");
		System.out.println("   Is empty? " + stack.empty());
		System.out.println("   Size: " + stack.size());

		// Push operations
		System.out.println("\n2. Push Operations:");
		String[] items = { "Bottom", "Middle", "Top" };
		for (String item : items) {
			String pushed = stack.push(item);
			System.out.println("   Pushed: " + pushed + " -> Stack: " + stack);
		}

		// Peek operation
		System.out.println("\n3. Peek Operation:");
		System.out.println("   Top element: " + stack.peek());
		System.out.println("   Stack unchanged: " + stack);

		// Search operation
		System.out.println("\n4. Search Operation:");
		for (String item : items) {
			int position = stack.search(item);
			System.out.println("   Position of '" + item + "': " + position);
		}

		// Pop operations
		System.out.println("\n5. Pop Operations:");
		while (!stack.empty()) {
			String popped = stack.pop();
			System.out.println("   Popped: " + popped + " -> Remaining: " + stack);
		}

		// Exception handling
		System.out.println("\n6. Exception Handling:");
		try {
			stack.pop();
		} catch (EmptyStackException e) {
			System.out.println("   Caught EmptyStackException on pop()");
		}

		try {
			stack.peek();
		} catch (EmptyStackException e) {
			System.out.println("   Caught EmptyStackException on peek()");
		}

		System.out.println("FERENCE COMPLETE");

	}
}
