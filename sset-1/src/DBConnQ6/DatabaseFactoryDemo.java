package DBConnQ6;

import java.util.*;

public class DatabaseFactoryDemo {
	public static void main(String[] args) {
		System.out.println("=== Advanced Database Connection Factory Demo ===\\n");

		// 1. Demonstrate available connection types
		System.out.println("1. Available Connection Types:");
		ConnectionFactory.getAvailableConnectionTypes().forEach(type -> {
			System.out.println("   - " + type + ": " + ConnectionFactory.getConnectionTypeDescription(type));
		});

		// 2. Demonstrate polymorphic connection creation
		System.out.println("\\n2. Polymorphic Connection Creation:");
		List<DatabaseConnection> connections = Arrays.asList(ConnectionFactory.createConnection("mysql"),
				ConnectionFactory.createConnection("postgresql"), ConnectionFactory.createConnection("mongodb"));

		// 3. Demonstrate uniform handling through interface
		System.out.println("\\n3. Uniform Operations Through DatabaseConnection Interface:");
		for (DatabaseConnection conn : connections) {
			System.out.println("\\n--- Operating on " + conn.getDatabaseType() + " ---");

			// Common operations through interface (polymorphism)
			conn.connect();
			conn.executeQuery("SELECT * FROM users");

			// Call beginTransaction on DatabaseConnection (available to all)
			conn.beginTransaction();

			// Demonstrate interface-specific behaviors
			if (conn instanceof ConnectionPoolable) {
				((ConnectionPoolable) conn).setPoolSize(20);
			}

			if (conn instanceof TransactionManageable) {
				((TransactionManageable) conn).beginTransaction();
				((TransactionManageable) conn).savepoint("checkpoint1");
				((TransactionManageable) conn).setTransactionTimeout(60);
			}

			if (conn instanceof SessionManageable) {
				((SessionManageable) conn).startSession();
			}

			// Execute query with results
			List<Map<String, Object>> results = conn.executeQueryWithResults("find data");
			System.out.println("Query results: " + results);

			conn.disconnect();
		}

		// 4. Demonstrate factory method with configuration
		System.out.println("\\n4. Factory Method with Configuration:");
		Map<String, Object> config = new HashMap<>();
		config.put("autoConnect", true);
		config.put("poolSize", 15);
		config.put("transactionTimeout", 60);
		DatabaseConnection configuredConn = ConnectionFactory.createConnection("mysql", config);
		System.out.println("Configured connection ID: " + configuredConn.getConnectionId());

		// 5. Demonstrate dynamic registration (Open/Closed Principle)
		System.out.println("\\n5. Dynamic Registration - Open/Closed Principle:");
		// Register a new connection type without modifying existing factory code
		ConnectionFactory.registerConnectionType("oracle", () -> new OracleConnection(),
				"Oracle database with advanced features");

		// Use the newly registered type
		DatabaseConnection oracleConn = ConnectionFactory.createConnection("oracle");
		oracleConn.connect();
		oracleConn.executeQuery("SELECT * FROM dual");
		oracleConn.disconnect();

		// 6. Demonstrate convenience static methods
		System.out.println("\\n6. Convenience Static Methods:");
		MySQLConnection mysql = ConnectionFactory.createMySQLConnection();
		PostgreSQLConnection postgres = ConnectionFactory.createPostgreSQLConnection();

		mysql.connect();
		mysql.enableQueryCache(true); // MySQL-specific method

		postgres.connect();
		postgres.enableJSONSupport(); // PostgreSQL-specific method

		// 7. Demonstrate error handling
		System.out.println("\\n7. Error Handling:");
		try {
			ConnectionFactory.createConnection("unknown_db");
		} catch (IllegalArgumentException e) {
			System.out.println("Expected error: " + e.getMessage());
		}
		
		
		// 8. Demonstrate TransactionManageable-specific behavior
        System.out.println("\n8. TransactionManageable Specific Behavior:");
        PostgreSQLConnection pgConn = ConnectionFactory.createPostgreSQLConnection();
        pgConn.connect();
        
        // Cast to TransactionManageable to access advanced features
        TransactionManageable transactionManager = (TransactionManageable) pgConn;
        transactionManager.beginTransaction();
        transactionManager.savepoint("sp1");
        transactionManager.setTransactionTimeout(120);
        System.out.println("Active transactions: " + transactionManager.getActiveTransactions());
        transactionManager.commitTransaction();
        
        pgConn.disconnect();
		
		
		
		

		// Cleanup
		mysql.disconnect();
		postgres.disconnect();
	}

	static class OracleConnection implements DatabaseConnection {
		private long connectionId = System.currentTimeMillis();
		private boolean connected = false;

		@Override
		public boolean connect() {
			connected = true;
			System.out.println("Oracle database connected");
			return true;
		}

		@Override
		public boolean disconnect() {
			connected = false;
			System.out.println("Oracle database disconnected");
			return true;
		}

		@Override
		public boolean isConnected() {
			return connected;
		}

		@Override
		public void executeQuery(String query) {
			System.out.println("Oracle executing: " + query);
		}

		@Override
		public List<Map<String, Object>> executeQueryWithResults(String query) {
			executeQuery(query);
			return Collections.singletonList(Collections.singletonMap("result", "Oracle data"));
		}

		@Override
		public int executeUpdate(String query) {
			executeQuery(query);
			return 1;
		}

		@Override
		public String getConnectionString() {
			return "jdbc:oracle:thin:@localhost:1521:XE";
		}

		@Override
		public String getDatabaseType() {
			return "Oracle";
		}

		@Override
		public long getConnectionId() {
			return connectionId;
		}

	}

}
