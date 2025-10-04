package debugCode.Q4;

public class Main4 {
	public static void main(String[] args) {
		System.out.println("=== Static Method Behavior (Method Hiding) ===");
		// Case 1: Base reference to Base object
		Base baseRef1 = new Base();
		baseRef1.staticMethod(); // Output: "Base static method"

		// Case 2: Derived reference to Derived object
		Derived derivedRef = new Derived();
		derivedRef.staticMethod(); // Output: "Derived static method"

		// Case 3: Base reference to Derived object (POLYMORPHIC SITUATION)
		Base baseRef2 = new Derived();
		baseRef2.staticMethod(); // Output: "Base static method" (REFERENCE TYPE determines call)

		// Case 4: Direct class calls (recommended for static methods)
		Base.staticMethod(); // Output: "Base static method"
		Derived.staticMethod(); // Output: "Derived static method"

		System.out.println("\\n=== Instance Method Behavior (Method Overriding) ===");
		// Case 1: Base reference to Base object
		baseRef1.instanceMethod(); // Output: "Base instance method"

		// Case 2: Derived reference to Derived object
		derivedRef.instanceMethod(); // Output: "Derived instance method"

		// Case 3: Base reference to Derived object (POLYMORPHIC SITUATION)
		baseRef2.instanceMethod(); // Output: "Derived instance method" (OBJECT TYPE determines call)

		System.out.println("\\n=== Additional Demonstrations ===");
		// Array demonstration
		Base[] objects = { new Base(), new Derived(), new Base() };
		for (Base obj : objects) {
			System.out.print("Static call: ");
			obj.staticMethod(); // Always calls Base.staticMethod()

			System.out.print("Instance call: ");
			obj.instanceMethod(); // Depends on actual object type
			System.out.println("---");
		}

	}
}
