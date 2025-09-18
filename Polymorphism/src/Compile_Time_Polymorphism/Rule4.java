package Compile_Time_Polymorphism;

//Varargs (Variable Arguments)
//If no other match is found, the compiler considers varargs methods.
public class Rule4 {
	public void print(int x) {
		System.out.println("Single int: " + x);
	}

	public void print(int... args) {
		System.out.print("Varargs: ");
		for (int arg : args) {
			System.out.print(arg + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Rule4 r4 = new Rule4();

		r4.print(5); // Exact match: print(int)
		r4.print(1, 2, 3); // Varargs: print(int...)
		r4.print(); // Varargs with no arguments
	}
}
