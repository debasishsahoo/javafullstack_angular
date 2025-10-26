package com.java.collection.list.vector.stack;

import java.util.Stack;

public class InheritedMethodsExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		System.out.println("=== Inherited Methods Demo ===\n");

		// Adding elements
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		stack.push("Fourth");
		System.out.println("Initial Stack: " + stack);

		// size() - Returns number of elements
		System.out.println("\n--- size() ---");
		System.out.println("Stack size: " + stack.size());

		// capacity() - Returns current capacity
		System.out.println("\n--- capacity() ---");
		System.out.println("Stack capacity: " + stack.capacity());

		// get(index) - Returns element at index
		System.out.println("\n--- get(index) ---");
		System.out.println("Element at index 0: " + stack.get(0));
		System.out.println("Element at index 2: " + stack.get(2));

		// set(index, element) - Replaces element at index
		System.out.println("\n--- set(index, element) ---");
		stack.set(1, "MODIFIED");
		System.out.println("After set(1, 'MODIFIED'): " + stack);

		// contains(Object) - Checks if element exists
		System.out.println("\n--- contains(Object) ---");
		System.out.println("Contains 'Third': " + stack.contains("Third"));
		System.out.println("Contains 'Fifth': " + stack.contains("Fifth"));

		// indexOf(Object) - Returns first occurrence index
		System.out.println("\n--- indexOf(Object) ---");
		System.out.println("Index of 'Third': " + stack.indexOf("Third"));

		// lastIndexOf(Object) - Returns last occurrence index
		System.out.println("\n--- lastIndexOf(Object) ---");
		stack.push("Third"); // Add duplicate
		System.out.println("Stack with duplicate: " + stack);
		System.out.println("Last index of 'Third': " + stack.lastIndexOf("Third"));

		// isEmpty() - Checks if stack is empty (different from empty())
		System.out.println("\n--- isEmpty() ---");
		System.out.println("Is empty: " + stack.isEmpty());

		// firstElement() - Returns first element (bottom)
		System.out.println("\n--- firstElement() ---");
		System.out.println("First element (bottom): " + stack.firstElement());

		// lastElement() - Returns last element (top)
		System.out.println("\n--- lastElement() ---");
		System.out.println("Last element (top): " + stack.lastElement());

		// remove(index) - Removes element at index
		System.out.println("\n--- remove(index) ---");
		stack.remove(2);
		System.out.println("After remove(2): " + stack);

		// removeElement(Object) - Removes first occurrence
		System.out.println("\n--- removeElement(Object) ---");
		stack.removeElement("Third");
		System.out.println("After removeElement('Third'): " + stack);

		// clear() - Removes all elements
		System.out.println("\n--- clear() ---");
		stack.clear();
		System.out.println("After clear(): " + stack);
		System.out.println("Size: " + stack.size());
	}
}
