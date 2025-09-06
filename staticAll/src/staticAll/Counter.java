package staticAll;
//Static variables are shared among all instances of a class.
//Only one copy exists regardless of how many objects are created.
//Static methods belong to the class and can be called without creating an object instance.
//They cannot access non-static (instance) variables or methods directly.
public class Counter {
	public static int count = 0; // 1
	public int instanceId;

	public Counter() {
		count++;
		instanceId = count;
	}

	public static int getCount() {
		return count;
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static double calculateArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();

		System.out.println("c1 instance ID: " + c1.instanceId);
		System.out.println("c2 instance ID: " + c2.instanceId);
		System.out.println("c3 instance ID: " + c3.instanceId);

		System.out.println("Total objects created: " + Counter.getCount());
		System.out.println("Sum: " + c1.add(3, 5)); //The static method add(int, int) from the type Counter should be accessed in a static way
		System.out.println("Area: " +Counter.calculateArea(3));

	}

}
