package StaticMembers;

public class Main {
	public static void main(String[] args) {
		// Accessing static members using class name (preferred)
		double area = MathUtils.calculateCircleArea(5.0); // Static Way

		System.out.println("Area: " + area);
		System.out.println("PI value: " + MathUtils.PI);

		// You can also access static members through object reference (not recommended)
		MathUtils utils0 = new MathUtils();
		System.out.println("utils0-" + utils0.getInstanceCount()); // Works but not preferred
		
		
		// Preferred way for static access
		System.out.println(MathUtils.getInstanceCount());

		// You can also access static members through object reference (not recommended)
		MathUtils utils1 = new MathUtils();
		System.out.println("utils1-" + utils1.getInstanceCount());

		// You can also access static members through object reference (not recommended)
		MathUtils utils2 = new MathUtils();
		System.out.println("utils2-" + utils2.getInstanceCount());

		// You can also access static members through object reference (not recommended)
		MathUtils utils3 = new MathUtils();
		System.out.println("utils3-" + utils3.getInstanceCount());
	}
}
