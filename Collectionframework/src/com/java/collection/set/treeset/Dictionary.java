package com.java.collection.set.treeset;

import java.util.Arrays;
import java.util.TreeSet;

public class Dictionary {

	public static void main(String[] args) {
		TreeSet<String> words = new TreeSet<>();

        words.add("Banana");
        words.add("Apple");
        words.add("Mango");
        words.add("Orange");

        System.out.println("Dictionary words: " + words);
        System.out.println("Words before 'Mango': " + words.headSet("Mango"));
        System.out.println("Words from 'Mango': " + words.tailSet("Mango"));
        
        
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Descending Set: " + ts.descendingSet());
        System.out.println("PollFirst(): " + ts.pollFirst());
        System.out.println("PollLast(): " + ts.pollLast());
        System.out.println("After polling: " + ts);
        
        
        
        

	}

}
