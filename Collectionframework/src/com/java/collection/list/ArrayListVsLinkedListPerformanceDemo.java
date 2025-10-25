package com.java.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListPerformanceDemo {

	public static void main(String[] args) {
		System.out.println("--- ArrayList vs LinkedList Performance ---");

        final int ELEMENTS = 100000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Measure add() time
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) arrayList.add(i);
        long end = System.nanoTime();
        System.out.println("ArrayList add() time: " + (end - start) / 1_000_000.0 + " ms");

        
        
        
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) linkedList.add(i);
        end = System.nanoTime();
        System.out.println("LinkedList add() time: " + (end - start) / 1_000_000.0 + " ms");

        
        
        
        // Measure get() time
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i += 1000) arrayList.get(i);
        end = System.nanoTime();
        System.out.println("ArrayList get() time: " + (end - start) / 1_000_000.0 + " ms");

        
        
        
        
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i += 1000) linkedList.get(i);
        end = System.nanoTime();
        System.out.println("LinkedList get() time: " + (end - start) / 1_000_000.0 + " ms");

	}

}
