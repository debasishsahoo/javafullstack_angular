package com.java.collection.set.linnkedhashset;

import java.util.*;

public class LinkedHashSetConstructors {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>();//Default cp=16 lf=0.75
        set1.add("A");
        set1.add("B");

        LinkedHashSet<String> set2 = new LinkedHashSet<>(20);
        set2.add("C");
        set2.add("D");

        LinkedHashSet<String> set3 = new LinkedHashSet<>(30, 0.5f);//Custom cp=20 lf=0.50
        set3.add("E");
        set3.add("F");

        LinkedHashSet<String> set4 = new LinkedHashSet<>(set3);
        System.out.println("set4: " + set4);
    }
}

