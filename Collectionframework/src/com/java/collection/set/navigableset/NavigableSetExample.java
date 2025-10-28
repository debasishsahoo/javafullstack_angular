package com.java.collection.set.navigableset;

import java.util.*;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> numbers = new TreeSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("NavigableSet: " + numbers);

        System.out.println("Lower(30): " + numbers.lower(30));       // < 30  //Returns the greatest element less than e.
        System.out.println("Floor(30): " + numbers.floor(30));       // <= 30 //Returns the greatest element ≤ e.
        System.out.println("Higher(30): " + numbers.higher(30));     // > 30  //Returns the smallest element greater than e.
        System.out.println("Ceiling(30): " + numbers.ceiling(30));   // >= 30 //Returns the smallest element ≥ e.
        
        
        System.out.println("headSet(30): " + numbers.headSet(30));         // Elements less than 30
        System.out.println("tailSet(30): " + numbers.tailSet(30));         // Elements greater than or equal to 30
        System.out.println("subSet(20, 40): " + numbers.subSet(20, 40));   // Elements between 20 and 40 (exclusive of 40)
        
        NavigableSet<Integer> reverseSet = numbers.descendingSet();
        System.out.println("Descending Set: " + reverseSet);
        
        
        System.out.println("pollFirst(): " + numbers.pollFirst());
        System.out.println("pollLast(): " + numbers.pollLast());
        System.out.println("Set after poll operations: " + numbers);
        
        
        
        
        
    }
}

