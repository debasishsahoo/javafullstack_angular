package com.java.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorRemoveExample {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 4, 5, 10, 15, 20));
		
		Iterator<Integer> it = numbers.iterator();
		
        while (it.hasNext()) {
            Integer num = it.next();
            if (num < 10) {
                it.remove();
            }
        }

        System.out.println("After removing elements < 10: " + numbers);

	}

}
