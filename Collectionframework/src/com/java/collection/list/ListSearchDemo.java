package com.java.collection.list;

import java.util.Arrays;
import java.util.List;

public class ListSearchDemo {

	public static void main(String[] args) {
		List<String> animals = Arrays.asList("Cat", "Dog", "Bird", "Dog");

		System.out.println("contains('Cat'): " + animals.contains("Cat"));

		System.out.println("indexOf('Dog'): " + animals.indexOf("Dog")); // First Occurrence

		System.out.println("lastIndexOf('Dog'): " + animals.lastIndexOf("Dog"));

		System.out.println("containsAll(['Cat','Dog']): " + animals.containsAll(Arrays.asList("Cat", "Dog")));
		System.out.println(
				"containsAll(['Cat','Dog','MAN']): " + animals.containsAll(Arrays.asList("Cat", "Dog", "MAN")));

	}

}
