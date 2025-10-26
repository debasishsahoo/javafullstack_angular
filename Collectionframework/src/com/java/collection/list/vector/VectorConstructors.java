package com.java.collection.list.vector;

import java.util.Vector;
import java.util.Arrays;
import java.util.List;

public class VectorConstructors {
    public static void main(String[] args) {
        System.out.println("=== Vector Constructors ===\n");

        // Constructor 1: Default constructor (capacity = 10)
        Vector<String> v1 = new Vector<>();
        System.out.println("1. Default Vector:");
        System.out.println("   Size: " + v1.size());
        System.out.println("   Capacity: " + v1.capacity());

        // Constructor 2: With initial capacity
        Vector<String> v2 = new Vector<>(20);
        System.out.println("\n2. Vector with initial capacity 20:");
        System.out.println("   Size: " + v2.size());
        System.out.println("   Capacity: " + v2.capacity());

        // Constructor 3: With initial capacity and capacity increment
        Vector<String> v3 = new Vector<>(15, 5);
        System.out.println("\n3. Vector with capacity 15 and increment 5:");
        System.out.println("   Size: " + v3.size());
        System.out.println("   Capacity: " + v3.capacity());

        // Add elements to exceed capacity and see increment
        for (int i = 0; i < 16; i++) {
            v3.add("Element" + i);
        }
        System.out.println("   After adding 16 elements:");
        System.out.println("   Size: " + v3.size());
        System.out.println("   Capacity: " + v3.capacity() + " (15 + 5)");

        // Constructor 4: From another collection
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        Vector<String> v4 = new Vector<>(list);
        System.out.println("\n4. Vector from collection:");
        System.out.println("   Elements: " + v4);
        System.out.println("   Size: " + v4.size());
        System.out.println("   Capacity: " + v4.capacity());
    }
}
