package com.java.collection.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<String> deque = new LinkedBlockingDeque<>(3);

		deque.putFirst("A");
		deque.putLast("B");
		deque.putLast("C");
		System.out.println("Deque: " + deque);

		// Trying to insert when full will block (wait)
		Thread producer = new Thread(() -> {
			try {
				System.out.println("Trying to add D...");
				deque.putLast("D");
				System.out.println("Added D successfully");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		producer.start();

		// Simulate consumer removing one element
		Thread.sleep(2000);
		System.out.println("Removed: " + deque.takeFirst());
		System.out.println("Deque after removal: " + deque);

	}

}
