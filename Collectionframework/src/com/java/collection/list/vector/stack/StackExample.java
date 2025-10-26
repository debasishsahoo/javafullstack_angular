package com.java.collection.list.vector.stack;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// Creating an empty Stack of integers
        Stack<Integer> stack = new Stack<>();

        // Checking if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // true

        // Pushing elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack elements: " + stack);
        
     // Peek at top
        System.out.println("Top: " + stack.peek());

        
        // Pop elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
     // Check if empty
        System.out.println("Is empty? " + stack.empty());
        
     // Search for element
        System.out.println("Position of Java: " + stack.search(10)); 
        
	}

}
