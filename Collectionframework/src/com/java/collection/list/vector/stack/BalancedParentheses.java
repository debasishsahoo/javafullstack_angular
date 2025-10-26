package com.java.collection.list.vector.stack;

import java.util.Stack;

public class BalancedParentheses {
	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();

		for (char ch : expression.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String expr = "{[()()]}{}";
		System.out.println(expr + " is balanced? " + isBalanced(expr));
	}
}
