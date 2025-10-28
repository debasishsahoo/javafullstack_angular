package com.java.collection.set.sortedset;

//implemented using a Red-Black Tree (a type of self-balancing binary search tree).
//Each insertion, deletion, and lookup maintains the sorted structure of the tree.
//That’s why its operations have O(log n) time complexity.

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {

	public static void main(String[] args) {
		SortedSet<Integer> numbers = new TreeSet<>();

        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);

        System.out.println("SortedSet elements: " + numbers);
        
        SortedSet<String> names = new TreeSet<>(Comparator.reverseOrder());
        names.add("D");
        names.add("F");
        names.add("A");
        names.add("C");

        System.out.println("Descending order: " + names);
        
        SortedSet<Integer> numbers2 = new TreeSet<>();
        
        for (int i = 1; i <= 10; i++)
            numbers2.add(i);
        
        System.out.println("Original Set: " + numbers2);
        System.out.println("Head Set (<5): " + numbers2.headSet(5));//Returns all elements less than toElement.
        System.out.println("Tail Set (>=5): " + numbers2.tailSet(5));//Returns all elements greater than or equal to fromElement.
        System.out.println("Sub Set (3 to 8): " + numbers2.subSet(3, 8));//Returns elements between fromElement (inclusive) and toElement (exclusive).
        System.out.println("first(): " + numbers2.first()); //Returns the first (lowest) element.
        System.out.println("last(): " + numbers2.last()); //Returns the last (highest) element.
        System.out.println("Comparator: " + numbers2.comparator());
        
        
        
        

	}

}
