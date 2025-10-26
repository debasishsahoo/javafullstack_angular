package com.java.collection.list.vector.stack;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		// Push elements
		stack.push("Java");
		stack.push("Python");
		stack.push("C++");

		// Peek at top
		System.out.println("Top: " + stack.peek()); // C++

		// Pop elements
		System.out.println("Popped: " + stack.pop()); // C++
		System.out.println("Popped: " + stack.pop()); // Python

		// Check if empty
		System.out.println("Is empty? " + stack.empty()); // false

		// Search for element
		System.out.println("Position of Java: " + stack.search("Java")); // 1
	}
}
