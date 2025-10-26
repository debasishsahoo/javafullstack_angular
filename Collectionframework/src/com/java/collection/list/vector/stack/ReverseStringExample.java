package com.java.collection.list.vector.stack;

import java.util.Stack;

public class ReverseStringExample {
	public static void main(String[] args) {
		System.out.println("=== Reverse String Using Stack ===\n");

		String original = "Hello World";
		String reversed = reverseString(original);

		System.out.println("Original: " + original);
		System.out.println("Reversed: " + reversed);
	}

	public static String reverseString(String str) {
		Stack<Character> stack = new Stack<>();

		// Push all characters
		for (char ch : str.toCharArray()) {
			stack.push(ch);
		}

		// Pop all characters
		StringBuilder reversed = new StringBuilder();
		while (!stack.empty()) {
			reversed.append(stack.pop());
		}

		return reversed.toString();
	}
}
