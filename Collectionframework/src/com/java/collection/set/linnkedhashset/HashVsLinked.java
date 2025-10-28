package com.java.collection.set.linnkedhashset;

import java.util.*;

public class HashVsLinked {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("Zebra");
        hs.add("Lion");
        hs.add("Tiger");
        hs.add("Elephant");

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Zebra");
        lhs.add("Lion");
        lhs.add("Tiger");
        lhs.add("Elephant");

        System.out.println("HashSet Output: " + hs);
        System.out.println("LinkedHashSet Output: " + lhs);
    }
}
