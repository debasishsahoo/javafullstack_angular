package com.java.collection.set.hashset;

public class InternalHashDemo {

	static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	public static void main(String[] args) {
		String key = "Java";

		int rawHashCode = key.hashCode();
		int processedHash = hash(key);

		System.out.println("Raw hash code: " + rawHashCode);
		System.out.println("Raw hash code (binary): " + Integer.toBinaryString(rawHashCode));

		System.out.println("\nProcessed hash: " + processedHash);
		System.out.println("Processed hash (binary): " + Integer.toBinaryString(processedHash));

		// Show the transformation
		System.out.println("\n--- Bit Mixing Process ---");
		
		System.out.println(
				"Original:     " + String.format("%32s", Integer.toBinaryString(rawHashCode)).replace(' ', '0'));
		
		System.out.println("Shifted >>>16: "
				+ String.format("%32s", Integer.toBinaryString(rawHashCode >>> 16)).replace(' ', '0'));
		
		System.out.println(
				"XOR Result:   " + String.format("%32s", Integer.toBinaryString(processedHash)).replace(' ', '0'));

	}

}
