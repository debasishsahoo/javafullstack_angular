package staticAll;

import java.util.Properties;
//Static blocks are executed when the class is first loaded, before any constructor is called. 
//They're used for complex static variable initialization.
public class DatabaseConfig {
	private static String connectionUrl;
	private static Properties props;

	// Static block - executes once when the class is first loaded
	static {
		System.out.println("Initializing database configuration...");
		props = new Properties();
		// Database connection URL
		connectionUrl = "jdbc:mysql://localhost:3306/mydb";
		// Add sample properties
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		props.setProperty("useSSL", "false");
		props.setProperty("autoReconnect", "true");
	}

	// Getter for connection URL
	public static String getConnectionUrl() {
		return connectionUrl;
	}

	// Getter for properties
	public static Properties getProperties() {
		return props;
	}

	public static void main(String[] args) {
		System.out.println("Database URL: " + DatabaseConfig.getConnectionUrl());
		System.out.println("Database User: " + DatabaseConfig.getProperties().getProperty("user"));
		System.out.println("Database Password: " + DatabaseConfig.getProperties().getProperty("password"));

	}
}
