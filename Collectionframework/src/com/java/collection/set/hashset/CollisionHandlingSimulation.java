package com.java.collection.set.hashset;

import java.util.*;

class SimpleNode {
    int hash;
    String key;
    SimpleNode next;

    SimpleNode(int hash, String key) {
        this.hash = hash;
        this.key = key;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        if (next != null) {
            sb.append(" -> ").append(next.toString());
        }
        return sb.toString();
    }
}

public class CollisionHandlingSimulation {
    private static final int CAPACITY = 8; // Small capacity to force collisions
    private SimpleNode[] buckets = new SimpleNode[CAPACITY];

    private int getBucketIndex(String key) {
        int hash = key.hashCode();
        hash = hash ^ (hash >>> 16);
        return Math.abs(hash) % CAPACITY;
    }

    public void add(String key) {
        int hash = key.hashCode();
        int index = getBucketIndex(key);

        System.out.println("\nAdding '" + key + "':");
        System.out.println("  Hash code: " + hash);
        System.out.println("  Bucket index: " + index);

        // Check if bucket is empty
        if (buckets[index] == null) {
            buckets[index] = new SimpleNode(hash, key);
            System.out.println("   Placed in empty bucket");
        } else {
            // Collision! Add to chain
            System.out.println("Collision detected! Adding to chain.");

            SimpleNode current = buckets[index];

            // Check for duplicate
            while (current != null) {
                if (current.hash == hash && current.key.equals(key)) {
                    System.out.println("  Duplicate found, not added");
                    return;
                }
                if (current.next == null) {
                    current.next = new SimpleNode(hash, key);
                    System.out.println("  Added to end of chain");
                    return;
                }
                current = current.next;
            }
        }
    }

    public void printBuckets() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("Current Bucket State:");
        System.out.println("=".repeat(80));

        for (int i = 0; i < CAPACITY; i++) {
            System.out.print("Bucket " + i + ": ");
            if (buckets[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println(buckets[i]);
            }
        }
    }

    public static void main(String[] args) {
        CollisionHandlingSimulation sim = new CollisionHandlingSimulation();

        String[] keys = {"Java", "Python", "C++", "JavaScript", "Ruby",
                         "Go", "Kotlin", "Swift", "Rust"};

        for (String key : keys) {
            sim.add(key);
        }

        sim.printBuckets();
    }
}

