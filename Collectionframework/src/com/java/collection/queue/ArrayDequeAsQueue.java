package com.java.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeAsQueue {

	public static void main(String[] args) {
		 Deque<String> deque = new ArrayDeque<>();

	        // Add elements at rear (like a normal Queue)
	        deque.offerLast("A");
	        deque.offerLast("B");
	        deque.offerLast("C");

	        System.out.println("Deque as Queue: " + deque);

	        // Remove elements from front (FIFO)
	        System.out.println("Removed: " + deque.pollFirst());
	        System.out.println("Removed: " + deque.pollFirst());

	        System.out.println("Deque after removals: " + deque);

	        // Peek first element
	        System.out.println("Front element: " + deque.peekFirst());

	}

}
