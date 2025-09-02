package getter_and_setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static volatile DatabaseConnection instance; // Singleton instance
	private Connection connection;

	// Private constructor to prevent direct instantiation
	private DatabaseConnection() {
		connection = createConnection();
	}

	//5. Lazy Loading
	// Thread-safe Singleton with Double-Checked Locking
	public static DatabaseConnection getInstance() {
		if (instance == null) {
			synchronized (DatabaseConnection.class) {
				if (instance == null) {
					instance = new DatabaseConnection();
				}
			}
		}
		return instance;
	}

	// Getter for connection
	public Connection getConnection() {
		return connection;
	}

	// Method to create DB connection
	private Connection createConnection() {
		try {
			// Load Driver (optional for newer JDBC versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Example: MySQL connection
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Failed to connect to DB", e);
		}
	}
}
