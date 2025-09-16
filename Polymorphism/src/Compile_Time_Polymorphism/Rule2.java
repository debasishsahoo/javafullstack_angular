package Compile_Time_Polymorphism;

//2. Widening Primitive Conversion
//If no exact match is found, 
//the compiler looks for methods that can accept the argument through widening conversions.
public class Rule2 {
	public void display(long x) {
		System.out.println("Long value: " + x);
	}

	public void display(double x) {
		System.out.println("Double value: " + x);
	}
	
	
	 public static void main(String[] args) {
		 Rule2 r2=new Rule2();
		 
		 r2.display(10);   // int widened to long (closest match)
		 r2.display(10.5f);  // float widened to double
		 
	 }
	
	//byte → short → int → long → float → double
	//char → int → long → float → double
	
	
	
}
