package com.java.collection.list.linklist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deque_Queue {

	public static void main(String[] args) {
		System.out.println("=== LINKEDLIST DEQUE & QUEUE OPERATIONS ===\n");

		demonstrateDequeOperations();
		demonstrateQueueOperations();

	}

	// DEQUE OPERATIONS (FIRST/LAST)
	public static void demonstrateDequeOperations() {
		System.out.println("\n--- DEQUE OPERATIONS (FIRST/LAST) ---");

		LinkedList<String> deque = new LinkedList<>();

		// addFirst(E element) - adds at the beginning
		deque.addFirst("First");
		deque.addFirst("New First");
		System.out.println("After addFirst(): " + deque);

		// addLast(E element) - adds at the end
		deque.addLast("Last");
		deque.addLast("New Last");
		System.out.println("After addLast(): " + deque);

		// getFirst() - retrieves first element
		String first = deque.getFirst();
		System.out.println("\ngetFirst(): " + first);

		// getLast() - retrieves last element
		String last = deque.getLast();
		System.out.println("getLast(): " + last);

		System.out.println("Current deque: " + deque);

		// removeFirst() - removes and returns first element
		String removedFirst = deque.removeFirst();
		System.out.println("\nremoveFirst(): " + removedFirst);
		System.out.println("After removeFirst(): " + deque);

		// removeLast() - removes and returns last element
		String removedLast = deque.removeLast();
		System.out.println("\nremoveLast(): " + removedLast);
		System.out.println("After removeLast(): " + deque);

		// removeFirstOccurrence(Object o)
		deque.addAll(Arrays.asList("A", "B", "A", "C", "A"));
		System.out.println("\nDeque: " + deque);
		boolean removed1 = deque.removeFirstOccurrence("A");
		System.out.println("removeFirstOccurrence('A'): " + removed1);
		System.out.println("Result: " + deque);

		// removeLastOccurrence(Object o)
		boolean removed2 = deque.removeLastOccurrence("A");
		System.out.println("\nremoveLastOccurrence('A'): " + removed2);
		System.out.println("Result: " + deque);
	}

	// QUEUE OPERATIONS
	public static void demonstrateQueueOperations() {
		System.out.println("\n--- QUEUE OPERATIONS ---");

		LinkedList<String> queue = new LinkedList<>();

		// offer(E element) - adds to end, returns boolean
		boolean offered1 = queue.offer("First");
		boolean offered2 = queue.offer("Second");
		boolean offered3 = queue.offer("Third");
		System.out.println("After offer operations: " + queue);
		System.out.println("All offers successful: " + (offered1 && offered2 && offered3));

		// peek() - retrieves but doesn't remove head, returns null if empty
		String peeked = queue.peek();
		System.out.println("\npeek(): " + peeked);
		System.out.println("Queue after peek: " + queue);

		// poll() - retrieves and removes head, returns null if empty
		String polled = queue.poll();
		System.out.println("\npoll(): " + polled);
		System.out.println("Queue after poll: " + queue);

		// element() - retrieves but doesn't remove head, throws exception if empty
		String element = queue.element();
		System.out.println("\nelement(): " + element);

		// remove() - retrieves and removes head, throws exception if empty
		String removed = queue.remove();
		System.out.println("remove(): " + removed);
		System.out.println("Queue after remove: " + queue);

		// Testing with empty queue
		queue.clear();
		System.out.println("\n--- Empty Queue Tests ---");
		System.out.println("peek() on empty: " + queue.peek()); // Returns null
		System.out.println("poll() on empty: " + queue.poll()); // Returns null

		try {
			queue.element(); // Throws exception
		} catch (NoSuchElementException e) {
			System.out.println("element() on empty throws: " + e.getClass().getSimpleName());
		}
	}
}
