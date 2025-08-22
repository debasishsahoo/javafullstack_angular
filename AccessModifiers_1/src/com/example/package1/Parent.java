package com.example.package1;

public class Parent {
	public String publicInheritance = "Public from Parent";
	protected String protectedInheritance = "Protected from Parent";
	String defaultInheritance = "Default from Parent";
	private String privateInheritance = "Private from Parent";

	public void publicParentMethod() {
		System.out.println("Public parent method");
	}

	protected void protectedParentMethod() {
		System.out.println("Protected parent method");
	}

	void defaultParentMethod() {
		System.out.println("Default parent method");
	}

	private void privateParentMethod() {
		System.out.println("Private parent method");
	}
}
