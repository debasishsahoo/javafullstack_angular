package com.java.collection.set.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetIntroduction {

	public static void main(String[] args) {
		// List with duplicates
        List<String> listWithDuplicates = Arrays.asList(
            "Apple", "Banana", "Apple", "Orange", "Banana", "Mango"
        );
        
        
        System.out.println("Original List: " + listWithDuplicates);

        // Remove duplicates using HashSet
        Set<String> uniqueFruits = new HashSet<>(listWithDuplicates);
        
        System.out.println("After removing duplicates: " + uniqueFruits);
        System.out.println("Original size: " + listWithDuplicates.size());
        System.out.println("Unique elements: " + uniqueFruits.size());
    }
        
        
        
        
        
        
        
        

	}


