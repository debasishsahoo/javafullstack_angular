package com.java.collection.list.arraylist;

import java.io.Serializable;
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> names = new ArrayList<>();

        // Add elements
        names.add("Debasish");
        names.add("Sahoo");
        names.add("Java");
        names.add("Developer");

        // Access elements
        System.out.println("First Name: " + names.get(0));

        // Update element
        names.set(2, "Full Stack Developer");

        // Remove element
        names.remove("Sahoo");

        // Iterate using forEach (Java 8+)
        names.forEach(System.out::println);

        // Clone the list
        ArrayList<String> clonedList = (ArrayList<String>) names.clone();
        System.out.println("Cloned List: " + clonedList);

        // Check RandomAccess
        if (names instanceof RandomAccess) {
            System.out.println("ArrayList supports fast random access.");
        }

        // Serialize check
        System.out.println("ArrayList is Serializable: " + (names instanceof Serializable));
    }
}

