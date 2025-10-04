package debugCode;

public class Main2 {

	public static void main(String[] args) {
		// Demonstrate static method creating instance
		ConfigurationManager defaultConfig = ConfigurationManager.createDefault();
		defaultConfig.printInstanceInfo();

		// Demonstrate instance methods
		ConfigurationManager customConfig = new ConfigurationManager("CustomConfig");
		customConfig.printInstanceInfo();

		// Demonstrate updateName with proper 'this' usage
		customConfig.updateName("UpdatedConfig");
		customConfig.printInstanceInfo();

		// Demonstrate display() method
		customConfig.display();

		// Demonstrate static method accessing only static data
		ConfigurationManager.printTotalInstances();

		// Create another instance to show instanceCount incrementing
		ConfigurationManager anotherConfig = new ConfigurationManager("Another");
		anotherConfig.printInstanceInfo();
		ConfigurationManager.printTotalInstances();

		// Show what happens with toString()
		System.out.println("String representation: " + defaultConfig);
	}

}
