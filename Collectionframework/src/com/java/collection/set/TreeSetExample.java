package com.java.collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<>();

		numbers.add(50);
		numbers.add(20);
		numbers.add(40);
		numbers.add(10);

		System.out.println("Numbers in sorted order: " + numbers);
	}
}
