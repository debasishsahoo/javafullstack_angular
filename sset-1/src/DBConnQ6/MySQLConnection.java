package DBConnQ6;

import java.util.*;
//MySQL Connection with connection pooling
public class MySQLConnection implements DatabaseConnection, ConnectionPoolable{
	    private static long nextId = 1;
	    private final long connectionId;
	    private boolean connected;
	    private int poolSize;
	    private boolean fromPool;
	    private List<String> queryCache;
	    
	    public MySQLConnection() {
	        this.connectionId = nextId++;
	        this.connected = false;
	        this.poolSize = 10; // default
	        this.queryCache = new ArrayList<>();
	    }
	    
	    @Override
	    public boolean connect() {
	        this.connected = true;
	        System.out.println("MySQL connected with pool size: " + poolSize);
	        return true;
	    }
	    
	    @Override
	    public boolean disconnect() {
	        this.connected = false;
	        System.out.println("MySQL connection " + connectionId + " disconnected");
	        return true;
	    }
	    
	    @Override
	    public boolean isConnected() {
	        return connected;
	    }
	    
	    @Override
	    public void executeQuery(String query) {
	        if (!connected) throw new IllegalStateException("Not connected");
	        queryCache.add(query);
	        System.out.println("MySQL executing: " + query);
	    }
	    
	    @Override
	    public List<Map<String, Object>> executeQueryWithResults(String query) {
	        executeQuery(query);
	        // Simulate results
	        List<Map<String, Object>> results = new ArrayList<>();
	        Map<String, Object> row = new HashMap<>();
	        row.put("id", 1);
	        row.put("data", "sample");
	        results.add(row);
	        return results;
	    }
	    @Override
	    public int executeUpdate(String query) {
	        executeQuery(query);
	        return 1; // Simulate affected rows
	    }
	    
	    @Override
	    public String getConnectionString() {
	        return "jdbc:mysql://localhost:3306/mydb";
	    }
	    
	    @Override
	    public String getDatabaseType() {
	        return "MySQL";
	    }

	    @Override
	    public long getConnectionId() {
	        return connectionId;
	    }
	    
}
