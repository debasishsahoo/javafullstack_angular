package com.java.collection.set.treeset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetConstructors {

	public static void main(String[] args) {
		TreeSet<Integer> ts1 = new TreeSet<>();  // natural order
        ts1.add(3);
        ts1.add(1);
        ts1.add(2);
        System.out.println("ts1: " + ts1);

        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        TreeSet<Integer> ts2 = new TreeSet<>(list);
        System.out.println("ts2: " + ts2);

        TreeSet<Integer> ts3 = new TreeSet<>(Comparator.reverseOrder());
        ts3.addAll(Arrays.asList(10, 20, 5, 15));
        System.out.println("ts3 (desc order): " + ts3);
        
        
        TreeSet<Integer> ts4 = new TreeSet<>();
        ts4.add(10);
        ts4.add(5);
        ts4.add(20);
        ts4.add(15);
        System.out.println("ts4: " + ts4);
        
        //          10
        //         /  \
        //        5    20
        //             / 
        //            15
        
        
        
        

	}

}
