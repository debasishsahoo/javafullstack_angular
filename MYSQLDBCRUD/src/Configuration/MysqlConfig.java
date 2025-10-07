package Configuration;
import java.sql.*;

public class MysqlConfig {
	private static final String URL = "jdbc:mysql://localhost:3306/crud_db";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
