package InheritanceLimitations;

class Database {
	 private String connectionString;
	 
	 Database(String connectionString) {
	        this.connectionString = connectionString;
	        System.out.println("Database connected: " + connectionString);
	    }
	
}
//This causes error because Database has no default constructor
//class MySQLDatabase extends Database { } // ❌ ERROR


//Must explicitly call parent constructor
class MySQLDatabase extends Database {
    MySQLDatabase(String connectionString) {
        super(connectionString); // Must call parent constructor
        System.out.println("MySQL database initialized");
    }
}



public class Rule3 {

}
