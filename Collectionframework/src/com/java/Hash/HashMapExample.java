package com.java.Hash;

//key–value pair
//Each key is unique.
//Each value is associated with one key.
//Keys can’t be duplicated, but values can.
//Unordered — No insertion order is maintained.
//Allows one null key and multiple null values.
//Backed by a hash table.
//hash = (h = key.hashCode()) ^ (h >>> 16);
//index = (n - 1) & hash;

//If multiple keys hash to the same bucket, 
//they form a LinkedList (or a TreeNode if > 8 elements — treeification).
//Load Factor (default 0.75) — When 75% of buckets are full, HashMap doubles its capacity.

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		
		map.put(101, "Alice");
        map.put(102, "Bob");
        map.put(103, "Charlie");
        map.put(104, "David");
        map.put(102, "Bobby");// Replaces existing value
        
        System.out.println("HashMap: " + map);
        
        System.out.println("Value for key 103: " + map.get(103));
        System.out.println("Contains key 104? " + map.containsKey(104));
        System.out.println("Contains value 'Alice'? " + map.containsValue("Alice"));
        
     // Iterating through entries
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " → Value: " + entry.getValue());
        }
		
        Map<Integer, String> linkedhashmap = new LinkedHashMap<>();
        
        linkedhashmap.put(1, "Apple");
        linkedhashmap.put(2, "Banana");
        linkedhashmap.put(3, "Cherry");
        linkedhashmap.put(4, "Date");
        
        //Maintains insertion order.
        //Uses doubly linked list internally along with hash table.
        //Slightly slower than HashMap, but predictable iteration order

        System.out.println("LinkedHashMap: " + linkedhashmap);
        
        Map<Integer, String> treemap = new TreeMap<>();
        //Sorted based on natural ordering of keys or custom Comparator.
        //Does not allow null keys.
        //Backed by a Red-Black Tree (self-balancing tree).
        treemap.put(50, "Zebra");
        treemap.put(10, "Apple");
        treemap.put(30, "Mango");
        treemap.put(20, "Banana");

        System.out.println("TreeMap (Sorted): " + treemap);
        
        Map<Integer, String> hashtablemap = new Hashtable<>();
        //Thread-safe (synchronized methods).
        //No null keys or null values.
        //Slower compared to ConcurrentHashMap.
        hashtablemap.put(1,"A");
        hashtablemap.put(2,"B");
        hashtablemap.put(3,"C");
        
        System.out.println("Hashtable: " + hashtablemap);
		
	}

}
