package com.java.collection.list.vector.stack;

import java.util.Stack;

public class PushExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		System.out.println("=== push() Method Demo ===");

		// Pushing elements
		Integer item1 = stack.push(10);
		System.out.println("Pushed: " + item1 + ", Stack: " + stack);

		Integer item2 = stack.push(20);
		System.out.println("Pushed: " + item2 + ", Stack: " + stack);

		Integer item3 = stack.push(30);
		System.out.println("Pushed: " + item3 + ", Stack: " + stack);

		stack.push(40);
		stack.push(50);
		System.out.println("Final Stack: " + stack);

		// Pushing different data types
		Stack<String> stringStack = new Stack<>();
		stringStack.push("First");
		stringStack.push("Second");
		stringStack.push("Third");
		System.out.println("String Stack: " + stringStack);
	}
}
