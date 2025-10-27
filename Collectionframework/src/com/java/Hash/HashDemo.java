package com.java.Hash;

public class HashDemo {

	public static void main(String[] args) {
		String s="APURBA";
		//s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			System.out.println("hash = " + "31 *"+ hash + " "+s.charAt(i));
		    hash = 31 * hash + s.charAt(i);
		    
		}
		
		System.out.println("hash = " + hash);
		
		
		
		
		System.out.println("\"ABC\".hashCode() = " + "ABC".hashCode());
        System.out.println("\"Aa\".hashCode()  = " + "Aa".hashCode());
        System.out.println("\"BB\".hashCode()  = " + "BB".hashCode());
        System.out.println("Integer 42 hash   = " + Integer.valueOf(42).hashCode());

	}

}
