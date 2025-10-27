package com.java.Hash.hashmap;

import java.util.Objects;

public class HashMapProcess {

    // === 1️ Entry class: each node in the HashMap chain ===
    static class Entry<K, V> {
        final K key;
        V value;
        final int hash;
        Entry<K, V> next; // points to next entry in same bucket (for collisions)

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    // === 2️ Simplified HashMap ===
    static class SimpleHashMap<K, V> {
        private Entry<K, V>[] table; // array of buckets
        private int size;
        private static final int DEFAULT_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public SimpleHashMap() {
            table = new Entry[DEFAULT_CAPACITY]; // initialize 16 buckets
            size = 0;
        }

        // --- Step 1: Hash calculation (like in Java 8) ---
        private int hash(K key) {
            if (key == null) return 0;
            int h = key.hashCode();
            // Mix upper bits into lower bits to reduce collisions
            return h ^ (h >>> 16);
        }

        // --- Step 2: Compute index (bucket position) ---
        private int indexFor(int hash, int length) {
            // Since capacity is power of 2, this is equivalent to hash % length
            return hash & (length - 1);
        }

        // --- Step 3: PUT operation (add or update key-value) ---
        public void put(K key, V value) {
            int hash = hash(key);
            int index = indexFor(hash, table.length);

            System.out.println("\n[PUT] Key: " + key + ", Hash: " + hash + ", Index: " + index);

            // Traverse the bucket chain to check if key already exists
            for (Entry<K, V> e = table[index]; e != null; e = e.next) {
                if (e.hash == hash && Objects.equals(e.key, key)) {
                    System.out.println("  → Key already exists! Updating value.");
                    e.value = value;
                    return;
                }
            }

            // Create new entry at the head of the linked list
            Entry<K, V> newEntry = new Entry<>(hash, key, value, table[index]);
            table[index] = newEntry;
            size++;

            System.out.println("  → Inserted new Entry: " + newEntry);
        }

        // --- Step 4: GET operation (retrieve value by key) ---
        public V get(K key) {
            int hash = hash(key);
            int index = indexFor(hash, table.length);

            System.out.println("\n[GET] Searching for Key: " + key + " (Index " + index + ")");

            for (Entry<K, V> e = table[index]; e != null; e = e.next) {
                System.out.println("  Checking entry: " + e.key);
                if (e.hash == hash && Objects.equals(e.key, key)) {
                    System.out.println("  → Found! Value = " + e.value);
                    return e.value;
                }
            }

            System.out.println("  → Key not found.");
            return null;
        }

        // --- Step 5: Display internal structure ---
        public void printTable() {
            System.out.println("\n=== HashMap Internal Structure ===");
            for (int i = 0; i < table.length; i++) {
                System.out.print("Bucket " + i + ": ");
                Entry<K, V> e = table[i];
                if (e == null) {
                    System.out.println("empty");
                } else {
                    while (e != null) {
                        System.out.print("[" + e + "] -> ");
                        e = e.next;
                    }
                    System.out.println("null");
                }
            }
        }

        public int size() {
            return size;
        }
    }

    // === 3️ Demonstration ===
    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("David", 40);

        // Force a collision (same bucket)
        map.put("Aa", 10);  // known to collide with "BB" in typical hash
        map.put("BB", 20);

        map.printTable();

        // Fetching values
        map.get("Alice");
        map.get("Charlie");
        map.get("BB");
        map.get("Eve"); // Not found

        System.out.println("\nMap Size: " + map.size());
    }
}
