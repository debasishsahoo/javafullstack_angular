package com.java.collection.list;

import java.util.Comparator;

public class StringComparatorDemo {

	public static void main(String[] args) {
		Comparator<String> cmp = (s1, s2) -> s1.compareTo(s2);

		System.out.println(cmp.compare("Apple", "Banana"));// negative (Apple < Banana)-1
		System.out.println(cmp.compare("Mango", "Grapes"));// positive (Mango > Grapes)6
		System.out.println(cmp.compare("Cat", "Cat")); // zero (equal)0
		System.out.println(cmp.compare("Banana", "Apple"));// positive (Banana > Apple)1

		// Negative → "Apple" comes before "Banana"
		// Positive → "Mango" comes after "Grapes"
		// Zero → Both are same

	}

}
