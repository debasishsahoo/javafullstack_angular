package BestPractices;

//BEST PRACTICE 1: Use meaningful names
public abstract class DataBaseConnection {
	abstract void connect();
}

// BEST PRACTICE 2: Group related abstract methods
abstract class FileHandler {
	abstract void open();

	abstract void read();

	abstract void write();

	abstract void close();
}

//BEST PRACTICE 3: Provide default implementations when possible
abstract class Logger {
	abstract void log(String message);

	// Default implementation
	void logError(String message) {
		log("ERROR: " + message);
	}

	void logInfo(String message) {
		log("INFO: " + message);
	}
}

//BEST PRACTICE 4: Use abstract classes for "is-a" relationships
abstract class Vehicle { // Car IS-A Vehicle
 abstract void start();
}


//BEST PRACTICE 5: Document abstract methods clearly
abstract class PaymentProcessor {
 /**
  * Process payment for the given amount
  * @param amount The amount to process
  * @return true if successful, false otherwise
  */
 abstract boolean process(double amount);
}





