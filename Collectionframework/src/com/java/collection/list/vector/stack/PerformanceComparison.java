package com.java.collection.list.vector.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PerformanceComparison {
	public static void main(String[] args) {
		System.out.println("=== Performance Comparison: Stack vs ArrayDeque ===\n");

		int iterations = 1000000;

		// Test Stack
		long stackStart = System.nanoTime();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < iterations; i++) {
			stack.push(i);
		}
		for (int i = 0; i < iterations; i++) {
			stack.pop();
		}
		long stackEnd = System.nanoTime();
		long stackTime = (stackEnd - stackStart) / 1000000;

		// Test ArrayDeque
		long dequeStart = System.nanoTime();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < iterations; i++) {
			deque.push(i);
		}
		for (int i = 0; i < iterations; i++) {
			deque.pop();
		}
		long dequeEnd = System.nanoTime();
		long dequeTime = (dequeEnd - dequeStart) / 1000000;

		System.out.println("Operations: " + iterations + " push + " + iterations + " pop");
		System.out.println("Stack time: " + stackTime + " ms");
		System.out.println("ArrayDeque time: " + dequeTime + " ms");
		System.out.println("ArrayDeque is " + String.format("%.2f", (double) stackTime / dequeTime) + "x faster");
	}
}
