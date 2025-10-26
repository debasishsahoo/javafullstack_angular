package com.java.collection.list.vector.stack;

import java.util.Stack;

public class DecimalToBinaryExample {
	public static void main(String[] args) {
		System.out.println("=== Decimal to Binary Converter ===\n");

		int[] numbers = { 10, 25, 50, 100, 255 };

		for (int num : numbers) {
			String binary = decimalToBinary(num);
			System.out.println("Decimal: " + num + " -> Binary: " + binary);
		}
	}

	public static String decimalToBinary(int decimal) {
		if (decimal == 0)
			return "0";

		Stack<Integer> stack = new Stack<>();

		while (decimal > 0) {
			stack.push(decimal % 2);
			decimal = decimal / 2;
		}

		StringBuilder binary = new StringBuilder();
		while (!stack.empty()) {
			binary.append(stack.pop());
		}

		return binary.toString();
	}
}
