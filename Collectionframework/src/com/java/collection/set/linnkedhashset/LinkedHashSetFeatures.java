package com.java.collection.set.linnkedhashset;

//Maintains insertion order
//No duplicates allowed
//One null element allowed
//Based on LinkedHashMap
//Constant-time performance(O(1))
//Predictable iteration order
//Supports all Set operations
//Not thread-safe
//Implements Cloneable & Serializable
//Clone: create a shallow copy.
//Serialize: convert it to a byte stream for file storage or network transfer.
//ideal for unique + ordered collections
//Default initial capacity = 16
//Default load factor = 0.75
//   LinkedHashSet<Integer> lhs = new LinkedHashSet<>(20, 0.8f);

import java.util.LinkedHashSet;

public class LinkedHashSetFeatures {

	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("Java");
		lhs.add("Python");
		lhs.add("C++");
		lhs.add("Java"); // Duplicate ignored
		lhs.add(null); // One null allowed
		lhs.add(null); 
		
		
		System.out.println("LinkedHashSet Elements: " + lhs);
        System.out.println("Size: " + lhs.size());
        System.out.println("Contains 'Python'? " + lhs.contains("Python"));
        
        lhs.remove("C++");
        System.out.println("After Removing 'C++': " + lhs);

        System.out.println("Iteration:");
        for (String s : lhs)
            System.out.println(" -> " + s);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


	}

}
