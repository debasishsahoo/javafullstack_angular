package com.java.Hash.hashmap;

import java.util.HashMap;

public class HashMapInternals {
    public static void main(String[] args) {
        // HashMap uses hashing internally
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        
        System.out.println("Alice's age: " + map.get("Alice"));
    }
}
