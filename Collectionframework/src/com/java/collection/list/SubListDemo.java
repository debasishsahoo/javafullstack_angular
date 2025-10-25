package com.java.collection.list;

import java.util.*;

public class SubListDemo {
 public static void main(String[] args) {
     List<Integer> nums = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
     System.out.println("Original: " + nums);

     List<Integer> sub = nums.subList(2, 5);
     System.out.println("Sublist: " + sub);

     sub.set(0, 99);
     System.out.println("After modify sublist: " + nums);
     System.out.println("Sublist: " + sub);
 }
}

