package com.java.Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListIterator {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10, 20, 30, 40);
        Iterator<Integer> it = nums.iterator();
        
        System.out.print("ArrayList elements: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

	}

}
