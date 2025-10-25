package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAddDemo {

	public static void main(String[] args) {
		System.out.println("--- Adding Elements Demo ---");

		List<String> list = new ArrayList<>();

		list.add("Apple");
		list.add("Banana");

		list.add(1, "Avocado");

		System.out.println("After add(): " + list);

		list.addAll(Arrays.asList("Mango", "Orange"));
		System.out.println("After addAll(): " + list);

		list.add(null);
		list.add("Apple");
		System.out.println("With null and duplicate: " + list);

	}

}
