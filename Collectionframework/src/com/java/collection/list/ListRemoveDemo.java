package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemoveDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "B"));
		System.out.println("Original: " + list);

		list.remove(2);
		System.out.println("After remove(2): " + list);

		list.remove("B");
		System.out.println("After remove('B'): " + list);

		list.removeIf(s -> s.equals("A"));
		System.out.println("After removeIf(): " + list);

		list.clear();
		System.out.println("After clear(): " + list);

		List<Integer> listn = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		listn.remove(2);
		System.out.println("After remove(2): " + listn);
		listn.remove(2);
		System.out.println("After remove(2): " + listn);

	}

}
