package com.java.collection.list.vector.stack;

import java.util.Stack;

public class EmptyExample {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();

		System.out.println("=== empty() Method Demo ===");

		// Check empty stack
		System.out.println("Is stack empty? " + stack.empty());
		System.out.println("Stack size: " + stack.size());

		// Add elements
		stack.push('A');
		System.out.println("\nAfter pushing 'A':");
		System.out.println("Is stack empty? " + stack.empty());
		System.out.println("Stack: " + stack);

		stack.push('B');
		stack.push('C');
		System.out.println("\nAfter pushing more elements:");
		System.out.println("Is stack empty? " + stack.empty());
		System.out.println("Stack: " + stack);

		// Pop all elements
		while (!stack.empty()) {
			char element = stack.pop();
			System.out.println("Popped: " + element + ", Is empty? " + stack.empty());
		}

		System.out.println("\nFinal check - Is stack empty? " + stack.empty());
	}
}
