package com.example.package1;

public class AccessModifierMain {
	public static void main(String[] args) {
		System.out.println("=== ACCESS MODIFIERS DEMONSTRATION ===\n");

		// 1. Public access demonstration
		System.out.println("1. PUBLIC ACCESS:");
		PublicClass publicObj = new PublicClass();
		System.out.println(publicObj.publicField);
		publicObj.publicMethod();
		PublicClass.publicStaticMethod();

	}
}
