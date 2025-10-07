package DBConnQ6;

import java.util.*;
import java.util.function.Supplier;

//Advanced factory with static methods and dynamic registration
public class ConnectionFactory {
	// Registry for dynamic type registration
	private static final Map<String, Supplier<DatabaseConnection>> connectionRegistry = new HashMap<>();
	private static final Map<String, String> connectionDescriptions = new HashMap<>();

	// Static initialization - register built-in types
	static {
		registerConnectionType("mysql", MySQLConnection::new, "MySQL database with connection pooling");
		registerConnectionType("postgresql", PostgreSQLConnection::new,
				"PostgreSQL with advanced transaction management");
		registerConnectionType("mongodb", MongoDBConnection::new, "MongoDB with document session management");
	}

	// Private constructor to prevent instantiation
	private ConnectionFactory() {
		throw new AssertionError("Cannot instantiate utility class");
	}

	// Registration mechanism for new connection types
	public static void registerConnectionType(String typeKey, Supplier<DatabaseConnection> constructor,
			String description) {
		connectionRegistry.put(typeKey.toLowerCase(), constructor);
		connectionDescriptions.put(typeKey.toLowerCase(), description);
		System.out.println("Registered connection type: " + typeKey + " - " + description);

	}

	public static void unregisterConnectionType(String typeKey) {
		connectionRegistry.remove(typeKey.toLowerCase());
		connectionDescriptions.remove(typeKey.toLowerCase());
		System.out.println("Unregistered connection type: " + typeKey);
	}

	public static Set<String> getAvailableConnectionTypes() {
		return Collections.unmodifiableSet(connectionRegistry.keySet());
	}

	public static String getConnectionTypeDescription(String typeKey) {
		return connectionDescriptions.get(typeKey.toLowerCase());
	}

	// Static factory methods for specific types (convenience methods)
	public static MySQLConnection createMySQLConnection() {
		return new MySQLConnection();
	}

	public static PostgreSQLConnection createPostgreSQLConnection() {
		return new PostgreSQLConnection();
	}

	public static MongoDBConnection createMongoDBConnection() {
		return new MongoDBConnection();
	}

	// Polymorphic factory method using registration system

	public static DatabaseConnection createConnection(String typeKey) {
		Supplier<DatabaseConnection> constructor = connectionRegistry.get(typeKey.toLowerCase());
		if (constructor == null) {
			throw new IllegalArgumentException(
					"Unknown connection type: " + typeKey + ". Available types: " + getAvailableConnectionTypes());
		}
		return constructor.get();
	}

	// Factory method with configuration
	public static DatabaseConnection createConnection(String typeKey, Map<String, Object> config) {
		DatabaseConnection connection = createConnection(typeKey);
		applyConfiguration(connection, config);
		return connection;
	}

	// Bulk connection creation
	public static List<DatabaseConnection> createConnections(String typeKey, int count) {
		List<DatabaseConnection> connections = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			connections.add(createConnection(typeKey));
		}
		return connections;
	}

	// Helper method to apply configuration

	private static void applyConfiguration(DatabaseConnection connection, Map<String, Object> config) {
		if (config == null)
			return;

		// Apply common configuration
		if (config.containsKey("autoConnect") && (Boolean) config.get("autoConnect")) {
			connection.connect();
		}

		// Apply type-specific configuration using polymorphism and interfaces
		if (connection instanceof ConnectionPoolable && config.containsKey("poolSize")) {
			((ConnectionPoolable) connection).setPoolSize((Integer) config.get("poolSize"));
		}

		if (connection instanceof TransactionManageable && config.containsKey("transactionTimeout")) {
			((TransactionManageable) connection).setTransactionTimeout((Integer) config.get("transactionTimeout"));
		}

		if (connection instanceof SessionManageable && config.containsKey("sessionTimeout")) {
			((SessionManageable) connection).setSessionTimeout((Integer) config.get("sessionTimeout"));
		}
	}
}
