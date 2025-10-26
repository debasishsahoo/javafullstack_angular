package com.java.collection.list.vector.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class PeekExample {
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<>();

		System.out.println("=== peek() Method Demo ===");

		// Push elements
		stack.push(1.5);
		stack.push(2.7);
		stack.push(3.9);
		System.out.println("Stack: " + stack);

		// Peek at top element multiple times
		Double top1 = stack.peek();
		System.out.println("Peeked: " + top1 + ", Stack unchanged: " + stack);

		Double top2 = stack.peek();
		System.out.println("Peeked again: " + top2 + ", Stack unchanged: " + stack);

		// Pop and peek
		stack.pop();
		System.out.println("After pop, Stack: " + stack);
		Double top3 = stack.peek();
		System.out.println("Peeked: " + top3);

		// Clear stack and try peek
		stack.clear();
		System.out.println("\nStack after clear: " + stack);
		try {
			stack.peek();
		} catch (EmptyStackException e) {
			System.out.println("Exception caught: Cannot peek empty stack");
		}
	}
}
