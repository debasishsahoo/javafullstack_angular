package com.java.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DualUseDeque {

	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		
		 // Use as Queue
        deque.offerLast("1");
        deque.offerLast("2");
        deque.offerLast("3");
        System.out.println("As Queue: " + deque);
        
        deque.pollFirst(); // FIFO
        System.out.println("After FIFO remove: " + deque);
        
        // Use as Stack
        deque.push("X");
        deque.push("Y");
        System.out.println("As Stack: " + deque);

        deque.pop(); // LIFO
        System.out.println("After LIFO pop: " + deque);

	}

}
