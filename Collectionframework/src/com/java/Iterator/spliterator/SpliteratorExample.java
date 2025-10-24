package com.java.Iterator.spliterator;
//Splitable Iterator

//parallel traversal and efficient splitting of data 
//especially useful with Streams, parallel processing, and large collections.

import java.util.ArrayList;

//An iterator that can split itself into smaller parts to allow parallel iteration.

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Mango", "Orange");

		Spliterator<String> spliterator = fruits.spliterator();

//		// Process elements using tryAdvance()
//		System.out.println("Using tryAdvance():");
//		//Processes the next element if present.
//		while (spliterator.tryAdvance(System.out::println));
//
//		// or, simply use forEachRemaining()
//		System.out.println("\nUsing forEachRemaining():");
//		//spliterator Splits off some elements for parallel processing.
//		fruits.spliterator().forEachRemaining(System.out::println);
//		

		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			numbers.add(i);
		// Note: The split ratio is not fixed — the JVM decides the division
		// dynamically.
		Spliterator<Integer> spliterator1 = numbers.spliterator(); // 1-120 remaing 61-120
		Spliterator<Integer> spliterator2 = spliterator1.trySplit();// 1-60 remaing 31-60
		Spliterator<Integer> spliterator3 = spliterator2.trySplit(); // 1-30

//        System.out.println("Spliterator 1:");
//        spliterator1.forEachRemaining(System.out::println);
//
//        System.out.println("\nSpliterator 2:");
//        spliterator2.forEachRemaining(System.out::println);
//        
//        System.out.println("\nSpliterator 3:");
//        spliterator3.forEachRemaining(System.out::println);

		List<String> items = List.of("A", "B", "C", "D");

		Spliterator<String> sp = items.spliterator();

		System.out.println("Estimate size: " + sp.estimateSize());
		System.out.println("Characteristics: " + sp.characteristics());

		if (sp.hasCharacteristics(Spliterator.ORDERED))
			System.out.println("This Spliterator is ORDERED.");

	}

}
