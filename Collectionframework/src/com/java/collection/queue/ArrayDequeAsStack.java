package com.java.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeAsStack {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();

        // Push elements (add at front)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack (LIFO): " + stack);

        // Pop elements (remove from front)
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Stack after pops: " + stack);
        System.out.println("Top element: " + stack.peek());

	}

}
