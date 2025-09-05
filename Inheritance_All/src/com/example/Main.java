package com.example;

import com.other.Child1;

public class Main {

	public static void main(String[] args) {
		Parent1 parent = new Parent1();
		Child1 child = new Child1();
		Parent1 polyChild = new Child1();
		
		
		parent.defaultMethod(); 
		child.defaultMethod();
		polyChild.defaultMethod();
		
		

	}

}
