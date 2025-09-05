package com.example;

import com.other.Child1;

public class Main {

	public static void main(String[] args) {
		Parent1 parent = new Parent1();
		Child1 child = new Child1();
		Parent1 polyChild = new Child1();
		
		
		parent.defaultMethod(); 
		child.defaultMethod();
		child.test();
		polyChild.defaultMethod();
		polyChild.test();
	}

}

//- **Default methods** are **package-private**, so they cannot be overridden in subclasses from another package.
//- Polymorphic references **do not invoke the child’s “same-named” default method** if it is in a different package; they still call the parent’s method.
//- Attempting to call the child’s default method from a class in another package **will cause a compilation error**.