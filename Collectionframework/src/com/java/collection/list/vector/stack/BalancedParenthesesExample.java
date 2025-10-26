package com.java.collection.list.vector.stack;

import java.util.Stack;

public class BalancedParenthesesExample {
	public static void main(String[] args) {
		System.out.println("=== Balanced Parentheses Checker ===\n");

		String[] expressions = { "()", "(())", "((()))", "()())", "(()", "{[()]}", "{[(])}", "{{[[(())]]}}" };

		for (String expr : expressions) {
			boolean isBalanced = isBalanced(expr);
			System.out.println(expr + " -> " + (isBalanced ? "Balanced" : "Not Balanced"));
		}
	}

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();

		for (char ch : expression.toCharArray()) {
			// Push opening brackets
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			// Check closing brackets
			else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.empty()) {
					return false;
				}

				char top = stack.pop();
				if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
					return false;
				}
			}
		}

		return stack.empty();
	}
}
