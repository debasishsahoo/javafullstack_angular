package com.java.collection.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeExample {

	public static void main(String[] args) {
		Queue<String> adq = new ArrayDeque<>();

        adq.offer("Apple");
        adq.offer("Banana");
        adq.offer("Cherry");

        System.out.println("ArrayDeque Queue: " + adq);

        adq.poll();
        System.out.println("After poll: " + adq);

        adq.peek();
        System.out.println("After peek: " + adq);

	}

}
