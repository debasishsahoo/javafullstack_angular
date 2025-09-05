package com.other;

import com.example.Parent1;

public class Child1 extends Parent1 {
    // ❌ Not overriding - this is a new method
    void defaultMethod() {
        System.out.println("Child's own method");
    }

    public void test() {
        defaultMethod();  // Calls child's own method
        // Cannot call Parent's defaultMethod() from here
    }
}