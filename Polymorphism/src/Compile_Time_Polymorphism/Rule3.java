package Compile_Time_Polymorphism;
//Autoboxing/Unboxing
//If widening doesn't work,
//the compiler tries autoboxing (primitive to wrapper) or unboxing (wrapper to primitive).
public class Rule3 {
	public void process(Integer x) {
		System.out.println("Processing Integer wrapper: " + x);
	}
	public void process(int x) {
		System.out.println("Processing int primitive: " + x);
	}

	public void handle(int x) {
		System.out.println("Handling int: " + x);
	}
	 public static void main(String[] args) {
		 Rule3 r3=new Rule3();
		 
		  r3.process(10);           // Exact match: process(int)
		  r3.process(Integer.valueOf(10)); // Exact match: process(Integer)
		  r3.handle(Integer.valueOf(20));   // Unboxing: Integer → int
	 }
}
