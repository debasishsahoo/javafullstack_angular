package com.java.collection.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListAsDeque {

	public static void main(String[] args) {
		 Deque<String> deque = new LinkedList<>();

	        deque.addFirst("A");  // front
	        deque.addLast("B");   // rear
	        deque.addLast("C");   // rear
	        System.out.println("Deque: " + deque);

	        System.out.println("Removed from front: " + deque.removeFirst());
	        System.out.println("Removed from rear: " + deque.removeLast());

	        System.out.println("Deque after removal: " + deque);

	        deque.addFirst("X");
	        deque.addLast("Y");
	        System.out.println("After new insertions: " + deque);

	        System.out.println("First element: " + deque.peekFirst());
	        System.out.println("Last element: " + deque.peekLast());


	}

}
