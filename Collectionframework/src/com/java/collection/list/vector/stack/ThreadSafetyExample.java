package com.java.collection.list.vector.stack;

import java.util.Stack;

public class ThreadSafetyExample {
	public static void main(String[] args) {
		System.out.println("=== Thread Safety Demo ===\n");

		Stack<Integer> stack = new Stack<>();

		// Thread 1: Pushing elements
		Thread producer = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				stack.push(i);
				System.out.println("Pushed: " + i + " by " + Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Producer");

		// Thread 2: Popping elements
		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				try {
					Thread.sleep(150);
					if (!stack.empty()) {
						Integer value = stack.pop();
						System.out.println("Popped: " + value + " by " + Thread.currentThread().getName());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Consumer");

		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nFinal Stack: " + stack);
	}
}
