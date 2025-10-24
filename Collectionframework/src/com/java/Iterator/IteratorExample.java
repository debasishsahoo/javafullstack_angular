package com.java.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Debasish");
		names.add("Amit");
		names.add("Rahul");

		System.out.println("Original List: " + names);

		// Create iterator
		Iterator<String> itr = names.iterator();

		// Traverse elements
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println("Element: " + name);
		}
		
		// Remove last element returned by next()
        itr.remove();
        System.out.println("After remove(): " + names);

	}

}
