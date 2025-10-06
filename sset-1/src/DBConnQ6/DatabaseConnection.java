package DBConnQ6;

import java.util.*;

// Main interface for all database connections
public interface DatabaseConnection {
	// 1. Common database operations
	boolean connect();
	boolean disconnect();
	boolean isConnected();
	
	void executeQuery(String query); // Insert Data
	List<Map<String, Object>> executeQueryWithResults(String query); // View Data
	int executeUpdate(String query); // Update Data

	// 2. Connection metadata
	String getConnectionString();
	String getDatabaseType();
	long getConnectionId();

	// 3. Transaction management (default implementation)
	default boolean beginTransaction() {
		System.out.println("Basic transaction started");
		return true;
	}

	default boolean commitTransaction() {
		System.out.println("Basic transaction committed");
		return true;
	}

	default boolean rollbackTransaction() {
		System.out.println("Basic transaction rolled back");
		return true;
	}

}
