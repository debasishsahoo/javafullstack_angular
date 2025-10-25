package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortDemo {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>(Arrays.asList("John", "Alice", "Bob"));

		names.sort(Comparator.naturalOrder());
		System.out.println("Sorted ascending: " + names);

		names.sort(Comparator.reverseOrder());
		System.out.println("Sorted descending: " + names);

		Collections.reverse(names);
		System.out.println("After reverse(): " + names);

		// int compare(T o1, T o2);
		// 0== Both Obj are Equal ,
		// <0==o1 should come before o2,
		// >0== o1 should come after o2

		// Comparator.naturalOrder() gives a comparator that sorts elements in their
		// natural ascending order.For String, it means alphabetical order
		// Result:[Alice, Bob, John]

		// Comparator.reverseOrder() gives a comparator that sorts in descending order.
		// Result:[John, Bob, Alice]

		// Collections.reverse(names);
		// This simply reverses the current order of elements in the list.
		// If current list = [John, Bob, Alice]
		// After reverse → [Alice, Bob, John]

	}

}
