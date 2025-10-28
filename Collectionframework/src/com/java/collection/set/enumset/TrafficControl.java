package com.java.collection.set.enumset;

import java.util.EnumMap;

enum TrafficLight {
    RED, YELLOW, GREEN
}

public class TrafficControl {
    public static void main(String[] args) {
        EnumMap<TrafficLight, String> actions = new EnumMap<>(TrafficLight.class);
        actions.put(TrafficLight.RED, "STOP");
        actions.put(TrafficLight.YELLOW, "READY");
        actions.put(TrafficLight.GREEN, "GO");

        for (TrafficLight light : actions.keySet()) {
            System.out.println(light + " → " + actions.get(light));
        }
    }
}
