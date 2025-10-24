package com.java.Iterator;

import java.util.*;

public class HashMapIterator {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "AWS");
        map.put(2, "Azure");
        map.put(3, "GCP");

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}

