package com.java.collection;

import java.util.ArrayList;
import java.util.Collection;

public class BasicOperationsDemo {

	public static void main(String[] args) {
		 System.out.println("=== BASIC OPERATIONS DEMO ===\n");
		 
		  // Creating a Collection (using ArrayList implementation)
	        Collection<String> collection = new ArrayList<>();
	        
	     // 1. add(E e) - Adds element to collection
	        
	        System.out.println("1. add() Method:");
	        boolean added1 = collection.add("Java");
	        boolean added2 = collection.add("Python");
	        boolean added3 = collection.add("C++");
	        System.out.println("Added 'Java': " + added1);
	        System.out.println("Added 'Python': " + added2);
	        System.out.println("Collection: " + collection);
	        
	        
	     // 2. size() - Returns number of elements
	        System.out.println("\n2. size() Method:");
	        System.out.println("Size of collection: " + collection.size());
	        
	     // 3. isEmpty() - Checks if collection is empty
	        System.out.println("\n3. isEmpty() Method:");
	        System.out.println("Is collection empty? " + collection.isEmpty());
	        
	        
	     // 4. contains(Object o) - Checks if element exists
	        System.out.println("\n4. contains() Method:");
	        System.out.println("Contains 'Java'? " + collection.contains("Java"));
	        System.out.println("Contains 'Ruby'? " + collection.contains("Ruby"));
	        
	     // 5. remove(Object o) - Removes specified element
	        System.out.println("\n5. remove() Method:");
	        boolean removed = collection.remove("Python");
	        System.out.println("Removed 'Python': " + removed);
	        System.out.println("Collection after removal: " + collection);
	        
	     // 6. clear() - Removes all elements
	        System.out.println("\n6. clear() Method:");
	        Collection<String> tempCollection = new ArrayList<>(collection);
	        tempCollection.clear();
	        System.out.println("Collection after clear(): " + tempCollection);
	        System.out.println("Is empty after clear? " + tempCollection.isEmpty());

	}

}
