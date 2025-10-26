package com.java.collection.list.vector.stack;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class IterationExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println("Stack: " + stack);
		System.out.println();

		// Method 1: Using for-each loop
		System.out.println("--- For-each loop (bottom to top) ---");
		for (Integer num : stack) {
			System.out.print(num + " ");
		}
		System.out.println("\n");

		// Method 2: Using Iterator
		System.out.println("--- Iterator (bottom to top) ---");
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println("\n");

		// Method 3: Using ListIterator
		System.out.println("--- ListIterator (bottom to top) ---");
		ListIterator<Integer> listIterator = stack.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println("\n");

		// Method 4: Using ListIterator in reverse
		System.out.println("--- ListIterator reverse (top to bottom) ---");
		ListIterator<Integer> reverseIterator = stack.listIterator(stack.size());
		while (reverseIterator.hasPrevious()) {
			System.out.print(reverseIterator.previous() + " ");
		}
		System.out.println("\n");

		// Method 5: Using Enumeration (legacy)
		System.out.println("--- Enumeration (bottom to top) ---");
		Enumeration<Integer> enumeration = stack.elements();
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		System.out.println("\n");

		// Method 6: Using traditional for loop
		System.out.println("--- Traditional for loop (bottom to top) ---");
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println("\n");

		// Method 7: Using forEach with lambda
		System.out.println("--- forEach with lambda ---");
		stack.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		// Method 8: Popping all elements (destructive)
		System.out.println("--- Popping all elements (top to bottom) ---");
		Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
		while (!tempStack.empty()) {
			System.out.print(tempStack.pop() + " ");
		}
		System.out.println("\n");
		System.out.println("Original stack unchanged: " + stack);
	}
}
