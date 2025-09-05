package com.library.internal;

public class DatabaseConnection {
	void internalCleanup() {
        System.out.println("Performing internal cleanup");
    }

    void resetConnection() {
        System.out.println("Resetting connection");
    }

    // Public API methods
    public void connect() {
        System.out.println("Connecting to database");
    }

    public void disconnect() {
        System.out.println("Disconnecting from database");
    }
}
class ConnectionPool extends DatabaseConnection {
    @Override
    void internalCleanup() {  // ✅ Can override because same package
        System.out.println("ConnectionPool custom cleanup");
    }
}
