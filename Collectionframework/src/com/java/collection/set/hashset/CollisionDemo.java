package com.java.collection.set.hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionDemo {
    static int calculateBucketIndex(int hashCode, int capacity) {
        int hash = hashCode ^ (hashCode >>> 16);
        return (capacity - 1) & hash;
    }

    public static void main(String[] args) {
        int capacity = 16;

        // These strings might collide (land in same bucket)
        String[] keys = {"Aa", "BB", "C++", "Java", "Python"};

        System.out.println("Capacity: " + capacity);
        System.out.println("Checking for collisions:\n");
        System.out.println("=".repeat(80));

        Map<Integer, List<String>> buckets = new HashMap<>();

        for (String key : keys) {
            int hashCode = key.hashCode();
            int bucketIndex = calculateBucketIndex(hashCode, capacity);

            buckets.computeIfAbsent(bucketIndex, k -> new ArrayList<>()).add(key);

            System.out.println(String.format("%-10s | HashCode: %10d | Bucket: %2d",
                key, hashCode, bucketIndex));
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("\nBucket Distribution:");

        for (Map.Entry<Integer, List<String>> entry : buckets.entrySet()) {
            System.out.println("Bucket " + entry.getKey() + ": " + entry.getValue());
            if (entry.getValue().size() > 1) {
                System.out.println("COLLISION DETECTED!");
            }
        }
    }
}
