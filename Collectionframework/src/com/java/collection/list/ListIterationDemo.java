package com.java.collection.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterationDemo {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        System.out.println("For-each loop:");
        for (String f : fruits) System.out.println(f);

        System.out.println("\nUsing Iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nUsing forEach with lambda:");
        fruits.forEach(f -> System.out.println(f));

	}

}
