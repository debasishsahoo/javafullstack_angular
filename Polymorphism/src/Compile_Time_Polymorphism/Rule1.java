package Compile_Time_Polymorphism;

//1. Exact Match Resolution
//The compiler first looks for an exact match of parameter types.
public class Rule1 {

	public void process(int x) {
		System.out.println("Processing int: " + x);
	}

	public void process(double x) {
		System.out.println("Processing double: " + x);
	}

	public void process(String x) {
		System.out.println("Processing String: " + x);
	}

	public static void main(String[] args) {
		Rule1 r1=new Rule1();
		r1.process(10);       // Exact match: process(int)
		r1.process(10.5);     // Exact match: process(double)
		r1.process("Hello");  // Exact match: process(String)

	}

}
