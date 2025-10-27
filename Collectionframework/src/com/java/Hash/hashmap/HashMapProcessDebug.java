package com.java.Hash.hashmap;

import java.util.Objects;

//Simplified version of what happens inside HashMap
//Components of HashTable 
//1  Array (Bucket Array)
//2  Entry (Node)
//3  Hash Function
//4  Load Factor
//5  Threshold
//6  Capacity
//7  Rehashing Mechanism
//8  Synchronization Lock
//9  modCount (Modification Count)
//10 Enumeration / Iterator

//Simplified and Debug-Friendly HashMap Implementation
public class HashMapProcessDebug {

 // --- Inner Entry class ---
 static class Entry<K, V> {
     final K key;
     V value;
     Entry<K, V> next; // For handling collisions (linked list)
     final int hash;

     Entry(int hash, K key, V value, Entry<K, V> next) {
         this.hash = hash;
         this.key = key;
         this.value = value;
         this.next = next;
     }

     @Override
     public String toString() {
         return "[" + key + "=" + value + "]";
     }
 }

 // --- SimpleHashMap Implementation ---
 static class SimpleHashMap<K, V> {
     private Entry<K, V>[] table;
     private int size;
     private static final int DEFAULT_CAPACITY = 16;

     @SuppressWarnings("unchecked")
     public SimpleHashMap() {
         table = new Entry[DEFAULT_CAPACITY];
         size = 0;
     }

     // Step 1: Calculate hash
     private int hash(K key) {
         if (key == null) return 0;
         int h = key.hashCode();
         int mixed = h ^ (h >>> 16); // reduce collisions
         System.out.println("DEBUG: hashCode(" + key + ") = " + h + ", mixed = " + mixed);
         return mixed;
     }

     // Step 2: Calculate index
     private int indexFor(int hash, int length) {
         int index = hash & (length - 1);
         System.out.println("DEBUG: indexFor(hash=" + hash + ") = " + index);
         return index;
     }

     // Step 3: Put operation
     public void put(K key, V value) {
         System.out.println("\n=== PUT(" + key + ", " + value + ") ===");
         int hash = hash(key);
         int index = indexFor(hash, table.length);

         // Check existing entries at that index
         for (Entry<K, V> e = table[index]; e != null; e = e.next) {
        	 
        	 
             System.out.println("  Checking existing entry: " + e);
             
             
             if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                 System.out.println("  >> Key found, updating value from " + e.value + " to " + value);
                 e.value = value; // Update value
                 return;
             }
         }

         // Add new entry (at the head of the linked list)
         Entry<K, V> newEntry = new Entry<>(hash, key, value, table[index]);
         table[index] = newEntry;
         size++;

         System.out.println("  >> New entry added at index " + index+" New Entry is:"+newEntry);
         printTable();
     }

     // Step 4: Get operation
     public V get(K key) {
         System.out.println("\n=== GET(" + key + ") ===");
         int hash = hash(key);
         int index = indexFor(hash, table.length);

         for (Entry<K, V> e = table[index]; e != null; e = e.next) {
             System.out.println("  Checking entry: " + e);
             if (e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))) {
                 System.out.println("  >> Key found! Returning value: " + e.value);
                 return e.value;
             }
         }

         System.out.println("  >> Key not found, returning null");
         return null;
     }

     // Print internal structure of the table
     public void printTable() {
         System.out.println("\n--- HashMap Table State ---");
         for (int i = 0; i < table.length; i++) {
             System.out.print("Bucket " + i + ": ");
             Entry<K, V> e = table[i];
             while (e != null) {
                 System.out.print(e + " -> ");
                 e = e.next;
             }
             System.out.println("null");
         }
         System.out.println("----------------------------");
     }

     // Debug specific bucket
     public void debugBucket(int index) {
         System.out.print("DEBUG Bucket " + index + ": ");
         Entry<K, V> e = table[index];
         while (e != null) {
             System.out.print(e + " -> ");
             e = e.next;
         }
         System.out.println("null");
     }

     public int size() {
         return size;
     }
 }

 // --- Main method for testing ---
 public static void main(String[] args) {
     SimpleHashMap<String, Integer> map = new SimpleHashMap<>();

     // Normal insertions
     map.put("Alice", 25);
     map.put("Bob", 30);
     map.put("Charlie", 35);
     map.put("David", 40);
     map.put("David", 40);
     map.put("David", 45);

     // Intentional collision demo
     map.put("Aa", 10);
     map.put("BB", 20);

     // Retrieve values
     System.out.println("\nValue for 'Alice': " + map.get("Alice"));
     System.out.println("Value for 'Bob': " + map.get("Bob"));
     System.out.println("Value for 'Charlie': " + map.get("Charlie"));
     System.out.println("Value for 'Aa': " + map.get("Aa"));
     System.out.println("Value for 'BB': " + map.get("BB"));

     // Non-existing key
     System.out.println("Value for 'Unknown': " + map.get("Unknown"));

     // Debug specific bucket
     System.out.println("\nCheck specific bucket (collision demo):");
     map.debugBucket(0);

     System.out.println("\nFinal size of map: " + map.size());
 }
}
