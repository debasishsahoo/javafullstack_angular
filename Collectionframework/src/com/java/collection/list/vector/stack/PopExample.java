package com.java.collection.list.vector.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class PopExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		System.out.println("=== pop() Method Demo ===");

		// Push elements
		stack.push("Apple");
		stack.push("Banana");
		stack.push("Cherry");
		stack.push("Date");
		System.out.println("Initial Stack: " + stack);

		// Pop elements one by one
		String popped1 = stack.pop();
		System.out.println("Popped: " + popped1 + ", Remaining: " + stack);

		String popped2 = stack.pop();
		System.out.println("Popped: " + popped2 + ", Remaining: " + stack);

		String popped3 = stack.pop();
		System.out.println("Popped: " + popped3 + ", Remaining: " + stack);

		String popped4 = stack.pop();
		System.out.println("Popped: " + popped4 + ", Remaining: " + stack);

		// Attempting to pop from empty stack
		System.out.println("\nAttempting to pop from empty stack:");
		try {
			stack.pop();
		} catch (EmptyStackException e) {
			System.out.println("Exception caught: " + e.getClass().getSimpleName());
		}
	}
}
