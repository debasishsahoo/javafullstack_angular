package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListModifyDemo {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		System.out.println("Original: " + numbers);

		numbers.set(2, 35);
		System.out.println("After set(): " + numbers);

		numbers.replaceAll(n -> n * 2);
		System.out.println("After replaceAll(n -> n*2): " + numbers);

		List<String> words = new ArrayList<>(Arrays.asList("java", "world"));
		words.replaceAll(String::toUpperCase);
		System.out.println("After replaceAll(String::toUpperCase): " + words);

	}

}
