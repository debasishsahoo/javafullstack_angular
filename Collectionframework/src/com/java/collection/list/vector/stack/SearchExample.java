package com.java.collection.list.vector.stack;

import java.util.Stack;

public class SearchExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		System.out.println("=== search() Method Demo ===");

		// Push elements
		stack.push("Java"); // Position 5 from top
		stack.push("Python"); // Position 4 from top
		stack.push("C++"); // Position 3 from top
		stack.push("JavaScript"); // Position 2 from top
		stack.push("Ruby"); // Position 1 from top (top element)

		System.out.println("Stack: " + stack);
		System.out.println();

		// Search for elements
		System.out.println("Search 'Ruby' (top): " + stack.search("Ruby"));
		System.out.println("Search 'JavaScript': " + stack.search("JavaScript"));
		System.out.println("Search 'C++': " + stack.search("C++"));
		System.out.println("Search 'Python': " + stack.search("Python"));
		System.out.println("Search 'Java' (bottom): " + stack.search("Java"));
		System.out.println("Search 'Go' (not present): " + stack.search("Go"));

		// After popping
		System.out.println("\nAfter popping top element:");
		stack.pop();
		System.out.println("Stack: " + stack);
		System.out.println("Search 'JavaScript' (now top): " + stack.search("JavaScript"));
		System.out.println("Search 'Java': " + stack.search("Java"));

		// Demonstrating with duplicates
		System.out.println("\n--- Duplicate Elements Demo ---");
		Stack<Integer> numStack = new Stack<>();
		numStack.push(10);
		numStack.push(20);
		numStack.push(10);
		numStack.push(30);
		System.out.println("Stack with duplicates: " + numStack);
		System.out.println("Search 10 (returns first match from top): " + numStack.search(10));
	}
}
