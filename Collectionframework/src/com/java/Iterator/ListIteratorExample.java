package com.java.Iterator;
//Bidirectional Iterator
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Banana");
		fruits.add("Apple");

		ListIterator<String> listItr = fruits.listIterator();

		System.out.println("Forward Direction:");
		while (listItr.hasNext()) {
			System.out.println(listItr.next());
		}

		System.out.println("Backward Direction:");
		while (listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}

		listItr.add("Grapes");
		System.out.println("After add(): " + fruits);

	}

}
