package com.java.collection.set.hashset;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashSetInternalDemo {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		HashSet<String> set = new HashSet<>();

		// Add elements
		set.add("Java");
		set.add("Python");
		set.add("JavaScript");

		System.out.println("HashSet: " + set);

		// Access the internal HashMap using reflection
		Field mapField = HashSet.class.getDeclaredField("map");
		mapField.setAccessible(true);
		HashMap<String, Object> internalMap = (HashMap<String, Object>) mapField.get(set);

		System.out.println("\nInternal HashMap:");
		for (Map.Entry<String, Object> entry : internalMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		// Get the PRESENT object
		Field presentField = HashSet.class.getDeclaredField("PRESENT");
		presentField.setAccessible(true);
		Object presentObject = presentField.get(null);

		System.out.println("\nPRESENT object: " + presentObject);
		System.out.println("All values point to same PRESENT object: " + (internalMap.get("Java") == presentObject));
	}

}
