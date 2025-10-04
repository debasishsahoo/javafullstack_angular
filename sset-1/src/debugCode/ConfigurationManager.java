package debugCode;

public class ConfigurationManager {
	private static int instanceCount = 0;
	private String configName;
	private final int configId;

	public ConfigurationManager(String name) {
		this.configName = name;
		this.configId = instanceCount++;
	}

	// Fixed: Changed to instance method since it uses instance variables
	// public static void printInstanceInfo() {
	public void printInstanceInfo() {
		System.out.println("Config: " + this.configName + ", ID: " + this.configId);
		System.out.println("Total instances: " + instanceCount);
	}

	public void updateName(String configName) {
		this.configName = configName;
	}

	public static ConfigurationManager createDefault() {
		return new ConfigurationManager("Default");
	}

	public void display() {
		System.out.println(this);
	}

	// Added toString() for better object representation
	@Override
	public String toString() {
		return "ConfigurationManager{configName='" + configName + "', configId=" + configId + "}";
	}

	// Added static method to access static data only
	public static void printTotalInstances() {
		System.out.println("Total instances: " + instanceCount);
	}

}
