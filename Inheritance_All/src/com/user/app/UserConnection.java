package com.user.app;

import com.library.internal.DatabaseConnection;

public class UserConnection extends DatabaseConnection {
	// ❌ Cannot access or override package-private methods
	 internalCleanup(); // Not accessible
	 resetConnection(); // Not accessible

	// ✅ Can use public API methods
	public void establishConnection() {
		connect(); // Accessible
		disconnect(); // Accessible
		System.out.println("UserConnection established");
	}
}
