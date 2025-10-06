package DBConnQ6;

import java.util.*;

public class MongoDBConnection implements DatabaseConnection, SessionManageable {
	private static long nextId = 1;
	private final long connectionId;
	private boolean connected;
	private boolean sessionActive;
	private int sessionTimeout;
	private List<String> activeSessions;

	public MongoDBConnection() {
		this.connectionId = nextId++;
		this.connected = false;
		this.sessionActive = false;
		this.sessionTimeout = 30; // default 30 minutes
		this.activeSessions = new ArrayList<>();
	}

	@Override
	public boolean connect() {
		this.connected = true;
		System.out.println("MongoDB connected with session management");
		return true;
	}

	@Override
	public boolean disconnect() {
		if (sessionActive) {
			endSession();
		}
		this.connected = false;
		System.out.println("MongoDB connection " + connectionId + " disconnected");
		return true;
	}

	@Override
	public boolean isConnected() {
		return connected;
	}

	@Override
    public void executeQuery(String query) {
        if (!connected) throw new IllegalStateException("Not connected");
        System.out.println("MongoDB executing: " + query);
    }

    @Override
    public List<Map<String, Object>> executeQueryWithResults(String query) {
        executeQuery(query);
        List<Map<String, Object>> results = new ArrayList<>();
        Map<String, Object> document = new HashMap<>();
        document.put("_id", "507f1f77bcf86cd799439011");
        document.put("name", "MongoDB Document");
        document.put("value", 42);
        results.add(document);
        return results;
    }

    @Override
    public int executeUpdate(String query) {
        executeQuery(query);
        return 1; // Simulate document modified count
    }
	
	
    @Override
    public String getConnectionString() {
        return "mongodb://localhost:27017/mydb";
    }

    @Override
    public String getDatabaseType() {
        return "MongoDB";
    }

    @Override
    public long getConnectionId() {
        return connectionId;
    }

    // SessionManageable implementation
    @Override
    public void startSession() {
        this.sessionActive = true;
        String sessionId = "session_" + System.currentTimeMillis();
        activeSessions.add(sessionId);
        System.out.println("MongoDB session started: " + sessionId + " (timeout: " + sessionTimeout + "m)");
    }
	
    @Override
    public void endSession() {
        this.sessionActive = false;
        if (!activeSessions.isEmpty()) {
            String sessionId = activeSessions.remove(activeSessions.size() - 1);
            System.out.println("MongoDB session ended: " + sessionId);
        }
    }

    @Override
    public boolean isSessionActive() {
        return sessionActive;
    }

    @Override
    public void setSessionTimeout(int minutes) {
        this.sessionTimeout = minutes;
        System.out.println("MongoDB session timeout set to: " + minutes + " minutes");
    }

    // MongoDB-specific method
    public void createCollection(String collectionName) {
        System.out.println("MongoDB creating collection: " + collectionName);
    }
	
	
	
	
	
	
}
