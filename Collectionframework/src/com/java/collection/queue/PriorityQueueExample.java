package com.java.collection.queue;

//Elements are sorted in natural order, not insertion order.
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>();
		
		 pq.add(40);
	        pq.add(10);
	        pq.add(30);
	        pq.add(20);

	        System.out.println("PriorityQueue: " + pq);

	        while (!pq.isEmpty()) {
	            System.out.println("Removed: " + pq.poll());
	        }

	}

}
