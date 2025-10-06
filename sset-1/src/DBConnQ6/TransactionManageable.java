package DBConnQ6;

import java.util.List;

public interface TransactionManageable {
	void setTransactionTimeout(int seconds);
	boolean savepoint(String name);
	boolean rollbackToSavepoint(String name);
	List<String> getActiveTransactions();

	// Add the Transaction method
	boolean beginTransaction();
	boolean commitTransaction();
	boolean rollbackTransaction();
}
