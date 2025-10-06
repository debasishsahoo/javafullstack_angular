package DBConnQ6;

import java.util.*;

public class PostgreSQLConnection implements DatabaseConnection, TransactionManageable{
	private static long nextId = 1;
	private final long connectionId;
	private boolean connected;
	private int transactionTimeout;
	private List<String> activeTransactions;
	private Map<String, String> savepoints;

	public PostgreSQLConnection() {
		this.connectionId = nextId++;
		this.connected = false;
		this.transactionTimeout = 30; // default 30 seconds
		this.activeTransactions = new ArrayList<>();
		this.savepoints = new HashMap<>();
	}

	@Override
	public boolean connect() {
		this.connected = true;
		System.out.println("PostgreSQL connected with advanced transaction support");
		return true;
	}

	@Override
	public boolean disconnect() {
		if (!activeTransactions.isEmpty()) {
			System.out.println("Warning: " + activeTransactions.size() + " active transactions will be rolled back");
			rollbackAllTransactions();
		}
		this.connected = false;
		System.out.println("PostgreSQL connection " + connectionId + " disconnected");
		return true;
	}

	@Override
	public boolean isConnected() {
		return connected;
	}

	@Override
	public void executeQuery(String query) {
		if (!connected) throw new IllegalStateException("Not connected");
		System.out.println("PostgreSQL executing: " + query);
	}

	@Override
	public List<Map<String, Object>> executeQueryWithResults(String query) {
		executeQuery(query);
		List<Map<String, Object>> results = new ArrayList<>();
		Map<String, Object> row = new HashMap<>();
		row.put("id", 1);
		row.put("data", "PostgreSQL result");
		results.add(row);
		return results;
	}
	@Override
	public int executeUpdate(String query) {
		executeQuery(query);
		return 1;
	}

	@Override
	public String getConnectionString() {
		return "jdbc:postgresql://localhost:5432/mydb";
	}

	@Override
	public String getDatabaseType() {
		return "PostgreSQL";
	}

	@Override
	public long getConnectionId() {
		return connectionId;
	}


	@Override
	public boolean beginTransaction() {
		String txId = "tx_" + System.currentTimeMillis();
		activeTransactions.add(txId);
		System.out.println("PostgreSQL transaction started: " + txId + " (timeout: " + transactionTimeout + "s)");
		return true;
	}
	
	@Override
    public boolean commitTransaction() {
        if (!activeTransactions.isEmpty()) {
            String txId = activeTransactions.remove(activeTransactions.size() - 1);
            System.out.println("PostgreSQL transaction committed: " + txId);
            return true;
        }
        return false;
    }
	@Override
    public boolean rollbackTransaction() {
        if (!activeTransactions.isEmpty()) {
            String txId = activeTransactions.remove(activeTransactions.size() - 1);
            System.out.println("PostgreSQL transaction rolled back: " + txId);
            return true;
        }
        return false;
    }

	
	// TransactionManageable implementation
	@Override
	public void setTransactionTimeout(int seconds) {
		this.transactionTimeout = seconds;
		System.out.println("PostgreSQL transaction timeout set to: " + seconds + " seconds");
	}

	@Override
	public boolean savepoint(String name) {
		savepoints.put(name, "savepoint_" + System.currentTimeMillis());
		System.out.println("PostgreSQL savepoint created: " + name);
		return true;
	}

	@Override
	public boolean rollbackToSavepoint(String name) {
		if (savepoints.containsKey(name)) {
			System.out.println("PostgreSQL rolled back to savepoint: " + name);
			return true;
		}
		return false;
	}

	@Override
	public List<String> getActiveTransactions() {
		return new ArrayList<>(activeTransactions);
	}

	private void rollbackAllTransactions() {
		for (String tx : activeTransactions) {
			System.out.println("Rolling back transaction: " + tx);
		}
		activeTransactions.clear();
		savepoints.clear();
	}

	// PostgreSQL-specific method
	public void enableJSONSupport() {
		System.out.println("PostgreSQL JSON support enabled");
	}





















}
