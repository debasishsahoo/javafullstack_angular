package com.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListComparisonDemo {

	public static void main(String[] args) {
		System.out.println("--- List Comparison Demo ---");

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list3 = Arrays.asList(5, 4, 3, 2, 1);
		
		System.out.println("list1.equals(list2): " + list1.equals(list2));
        System.out.println("list1.equals(list3): " + list1.equals(list3));

        System.out.println("\nContent comparison (unordered):");
        System.out.println("list1 containsAll list3: " + list1.containsAll(list3));
        System.out.println("list3 containsAll list1: " + list3.containsAll(list1));

        System.out.println("\nUsing retainAll (common elements):");
        List<Integer> temp = new ArrayList<>(list1);
        temp.retainAll(list3);
        System.out.println("Common elements: " + temp);

	}

}
