package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListCreationDemo {

	public static void main(String[] args) {
		System.out.println("--- List Creation Demo ---");
		List<String> arrayList = new ArrayList<>();
		
		
		
		
		List<String> linkedList = new LinkedList<>();
		List<String> vector = new Vector<>();

		System.out.println("ArrayList: " + arrayList);
		System.out.println("LinkedList: " + linkedList);
		System.out.println("Vector: " + vector);

		List<String> fromArray = Arrays.asList("A", "B", "C");
		System.out.println("Fixed-size List (Arrays.asList): " + fromArray);

		List<String> immutable = List.of("X", "Y", "Z");
		System.out.println("Immutable List: " + immutable);

	}

}
