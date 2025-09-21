package FunctionalInterface;

import java.util.function.*;

public class MainCombinedDemo {
	public static void main(String[] args) {
		System.out.println("=== Custom Functional Interface ===");
		Calculator add = (a, b) -> a + b;
		Calculator multiply = (a, b) -> a * b;
		System.out.println("Add: " + add.operate(10, 5));
		System.out.println("Multiply: " + multiply.operate(10, 5));

		Greeter g = name -> System.out.println("Hi " + name);
		g.greet("Debasish");
		g.sayHello();
		Greeter.info();

		System.out.println("\n=== Built-in Functional Interfaces ===");
		Predicate<String> nonEmpty = s -> !s.isEmpty();
		System.out.println("Is 'Java' non-empty? " + nonEmpty.test("Java"));

	}
}
