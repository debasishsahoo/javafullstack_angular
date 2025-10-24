package com.java.Iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIterator {

	public static void main(String[] args) {
		Set<String> cities = new HashSet<>();
		cities.add("Kolkata");
		cities.add("Mumbai");
		cities.add("Delhi");

		Iterator<String> it = cities.iterator();
		System.out.println("Cities using Iterator:");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
