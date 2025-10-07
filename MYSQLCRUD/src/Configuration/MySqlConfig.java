package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {           
      private static final String URL="jdbc:mysql://localhost:3306/crud_db";
      private static final String USER="root";
      private static final String PASSWORD="123";
      
      public static Connection getConnection() throws SQLException{
    	  return DriverManager.getConnection(URL,USER,PASSWORD);
      }
      
      
}
