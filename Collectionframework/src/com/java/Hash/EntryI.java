package com.java.Hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//iterate over a map, we need both key and value.
//Map interface doesn’t directly provide a way to iterate key-value pairs together
//Each Entry object holds one key and one value.
//The Set of all entries can be obtained using map.entrySet().

public class EntryI {

	public static void main(String[] args) {
//		Map<Integer, String> map = new HashMap<>();
//
//		map.put(1, "Java");
//		map.put(2, "Python");
//		map.put(3, "C++");
//
//		// Iterate using entrySet()
//		for (Map.Entry<Integer, String> entry : map.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
//		
//		
//		 System.out.println("Before modification: " + map);
//		
//		for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            if (entry.getKey() == 2) {
//                entry.setValue("Blueberry");
//            }
//        }
//
//        System.out.println("After modification: " + map);
//        
//        
//        
//        
//        
//        Map<String, Integer> scores = new HashMap<>();
//        scores.put("Alice", 90);
//        scores.put("Bob", 85);
//        scores.put("Charlie", 95);
//
//        // 1️⃣ Get keys
//        Set<String> keys = scores.keySet();
//        System.out.println("Keys: " + keys);
//
//        // 2️⃣ Get values
//        Collection<Integer> values = scores.values();
//        System.out.println("Values: " + values);
//
//        // 3️⃣ Get entries
//        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
//        System.out.println("Entries: " + entries);
        
        
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        
        
        
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 85);
        marks.put("Science", 92);
        marks.put("English", 78);

        // Using forEach with Entry
        marks.forEach((subject, score) ->
            System.out.println(subject + " -> " + score)
        );

        // Using Stream API
        marks.entrySet().stream()
             .filter(e -> e.getValue() > 80)
             .forEach(e -> System.out.println("High Score: " + e.getKey() + " = " + e.getValue()));
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	}

}
