package com.java.collection.set.hashset;

import java.util.*;

public class SetOperationsDemo {
    public static void main(String[] args) {
        HashSet<String> setA = new HashSet<>(
            Arrays.asList("Java", "Python", "C++", "JavaScript")
        );
        HashSet<String> setB = new HashSet<>(
            Arrays.asList("Python", "Ruby", "Go", "JavaScript")
        );

        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("\n" + "=".repeat(80));

        // 1. UNION: All elements from both sets
        HashSet<String> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("\n1. UNION (A ∪ B):");
        System.out.println("   " + union);
        System.out.println("   Size: " + union.size());

        // 2. INTERSECTION: Common elements
        HashSet<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("\n2. INTERSECTION (A ∩ B):");
        System.out.println("   " + intersection);
        System.out.println("   Size: " + intersection.size());

        // 3. DIFFERENCE: Elements in A but not in B
        HashSet<String> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("\n3. DIFFERENCE (A - B):");
        System.out.println("   " + difference);
        System.out.println("   Size: " + difference.size());

        // 4. SYMMETRIC DIFFERENCE: Elements in either set but not both
        HashSet<String> symmetricDiff = new HashSet<>(union);
        symmetricDiff.removeAll(intersection);
        System.out.println("\n4. SYMMETRIC DIFFERENCE (A △ B):");
        System.out.println("   " + symmetricDiff);
        System.out.println("   Size: " + symmetricDiff.size());

        // 5. SUBSET CHECK
        HashSet<String> subset = new HashSet<>(Arrays.asList("Java", "Python"));
        System.out.println("\n5. SUBSET CHECK:");
        System.out.println("   Is " + subset + " a subset of A?");
        System.out.println("   " + setA.containsAll(subset));

        // 6. DISJOINT CHECK: No common elements
        HashSet<String> setC = new HashSet<>(Arrays.asList("Rust", "Swift"));
        System.out.println("\n6. DISJOINT CHECK:");
        System.out.println("   Are A and C disjoint (no common elements)?");
        System.out.println("   " + Collections.disjoint(setA, setC));
        System.out.println("   Are A and B disjoint?");
        System.out.println("   " + Collections.disjoint(setA, setB));
    }
}

