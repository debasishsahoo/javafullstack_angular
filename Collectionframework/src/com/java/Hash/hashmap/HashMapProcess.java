package com.java.Hash.hashmap;

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

public class HashMapProcess {

	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next; // For handling collisions (chaining)
		final int hash;

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

	static class SimpleHashMap<K, V> {
		private Entry<K, V>[] table; // array of buckets
		private int size;
        private static final int DEFAULT_CAPACITY = 16;
        
        @SuppressWarnings("unchecked")
        public SimpleHashMap() {
            table = new Entry[DEFAULT_CAPACITY]; // initialize 16 buckets
            size = 0;
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
