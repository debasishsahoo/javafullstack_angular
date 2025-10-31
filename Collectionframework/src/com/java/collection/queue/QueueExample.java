package com.java.collection.queue;
//Breadth-first search (BFS) algorithms.
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		 Queue<String> queue = new LinkedList<>();
		 
		 // Adding elements
	        queue.add("A");
	        queue.add("B");
	        queue.add("C");
	        queue.offer("D");
	        
	        
	        System.out.println("Queue: " + queue);

	        // Access head element
	        System.out.println("Head (peek): " + queue.peek());

	        // Remove elements
	        System.out.println("Removed: " + queue.remove());
	        System.out.println("Removed(using poll): " + queue.poll());

	        System.out.println("Queue after removal: " + queue);

	        // Access head again
	        System.out.println("Head (element): " + queue.element());

	}

}
