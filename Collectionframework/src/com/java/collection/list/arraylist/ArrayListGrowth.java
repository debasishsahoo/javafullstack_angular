package com.java.collection.list.arraylist;

import java.util.ArrayList;
import java.lang.reflect.Field;

public class ArrayListGrowth {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(2);

        for (int i = 1; i <= 20; i++) {
            list.add(i);
            System.out.println("Added: " + i + " | Size: " + list.size() + " | Capacity: " + getCapacity(list));
        }
    }

    // Using reflection to access internal capacity
    private static int getCapacity(ArrayList<?> list) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        Object[] elementData = (Object[]) dataField.get(list);
        return elementData.length;
    }
}

