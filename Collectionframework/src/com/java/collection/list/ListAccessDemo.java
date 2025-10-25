package com.java.collection.list;

import java.util.Arrays;
import java.util.List;

public class ListAccessDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Red", "Green", "Blue", "Yellow");

		System.out.println("List: " + list);

		System.out.println("get(0): " + list.get(0));

		System.out.println("get(2): " + list.get(2));

		System.out.println("Last element: " + list.get(list.size() - 1));

		System.out.println("isEmpty(): " + list.isEmpty());
	}

}
