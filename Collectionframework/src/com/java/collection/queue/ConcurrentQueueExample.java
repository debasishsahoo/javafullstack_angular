package com.java.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExample {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> cq = new ConcurrentLinkedQueue<>();

        cq.add("Task1");
        cq.add("Task2");
        cq.add("Task3");

        System.out.println("Concurrent Queue: " + cq);

        System.out.println("Polled: " + cq.poll());
        System.out.println("After Poll: " + cq);

	}

}
