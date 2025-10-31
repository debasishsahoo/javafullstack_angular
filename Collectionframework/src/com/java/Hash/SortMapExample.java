package com.java.Hash;

import java.util.*;

public class SortMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Cherry", 2);

        // Sort by Key
        Map<String, Integer> sortedByKey = new TreeMap<>(map);
        System.out.println("Sorted by Key: " + sortedByKey);

        // Sort by Value
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println("Sorted by Value:");
        list.forEach(System.out::println);
    }
}

