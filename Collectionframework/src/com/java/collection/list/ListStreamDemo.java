package com.java.collection.list;

import java.util.Arrays;
import java.util.List;

public class ListStreamDemo {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		System.out.println("Even numbers:");
		nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("\nSquares:");
		nums.stream().map(n -> n * n).forEach(System.out::println);

		int sum = nums.stream().reduce(0, Integer::sum);
		System.out.println("\nSum = " + sum);

	}

}
