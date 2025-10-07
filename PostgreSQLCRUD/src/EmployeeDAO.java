import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {
	// CREATE
	public void addEmployee(Employee employee) {
		String query = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setString(3, employee.getDepartment());
			pstmt.setDouble(4, employee.getSalary());

			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println(" Employee added successfully!");
			}
		} catch (SQLException e) {
			System.out.println("Error adding employee: " + e.getMessage());
		}
	}

	// READ ALL
	public void getAllEmployees() {
		String query = "SELECT * FROM employees ORDER BY id";

		try (Connection conn = DatabaseConfig.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			System.out.println("\n" + "=".repeat(110));
			System.out.println("ALL EMPLOYEES");
			System.out.println("=".repeat(110));

			boolean hasRecords = false;

			while (rs.next()) {
				hasRecords = true;
				Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("department"), rs.getDouble("salary"));
				System.out.println(employee);
			}

			if (!hasRecords) {
				System.out.println("No employees found.");
			}
			System.out.println("=".repeat(110) + "\n");

		} catch (SQLException e) {
			System.out.println("Error retrieving employees: " + e.getMessage());
		}
	}

	// READ BY ID
	public void getEmployeeById(int id) {
		String query = "SELECT * FROM employees WHERE id = ?";

		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("department"), rs.getDouble("salary"));
				System.out.println("\n" + employee + "\n");
			} else {
				System.out.println("No employee found with ID: " + id);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving employee: " + e.getMessage());
		}
	}

	// READ BY DEPARTMENT
	public void getEmployeesByDepartment(String department) {
		String query = "SELECT * FROM employees WHERE LOWER(department) = LOWER(?) ORDER BY id";

		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, department);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("\n" + "=".repeat(110));
			System.out.println("EMPLOYEES IN " + department.toUpperCase() + " DEPARTMENT");
			System.out.println("=".repeat(110));

			boolean hasRecords = false;

			while (rs.next()) {
				hasRecords = true;
				Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("department"), rs.getDouble("salary"));
				System.out.println(employee);
			}

			if (!hasRecords) {
				System.out.println("No employees found in " + department + " department.");
			}
			System.out.println("=".repeat(110) + "\n");

		} catch (SQLException e) {
			System.out.println("Error retrieving employees: " + e.getMessage());
		}
	}

	// UPDATE
	public void updateEmployee(int id, String name, String email, String department, double salary) {
		String query = "UPDATE employees SET name = ?, email = ?, department = ?, salary = ? WHERE id = ?";

		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, department);
			pstmt.setDouble(4, salary);
			pstmt.setInt(5, id);

			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println(" Employee updated successfully!");
			} else {
				System.out.println("No employee found with ID: " + id);
			}

		} catch (SQLException e) {
			System.out.println("Error updating employee: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteEmployee(int id) {
		String query = "DELETE FROM employees WHERE id = ?";

		try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setInt(1, id);

			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println(" Employee deleted successfully!");
			} else {
				System.out.println("No employee found with ID: " + id);
			}

		} catch (SQLException e) {
			System.out.println("Error deleting employee: " + e.getMessage());
		}
	}

	// GET STATISTICS
	public void getStatistics() {
		String query = "SELECT department, COUNT(*) as emp_count, AVG(salary) as avg_salary "
				+ "FROM employees GROUP BY department ORDER BY department";

		try (Connection conn = DatabaseConfig.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			System.out.println("\n" + "=".repeat(70));
			System.out.println("DEPARTMENT STATISTICS");
			System.out.println("=".repeat(70));

			boolean hasRecords = false;

			while (rs.next()) {
				hasRecords = true;
				String dept = rs.getString("department");
				int count = rs.getInt("emp_count");
				double avgSalary = rs.getDouble("avg_salary");
				System.out.printf("Department: %-20s | Employees: %3d | Avg Salary: $%.2f%n", dept, count, avgSalary);
			}

			if (!hasRecords) {
				System.out.println("No statistics available.");
			}
			System.out.println("=".repeat(70) + "\n");

		} catch (SQLException e) {
			System.out.println("Error retrieving statistics: " + e.getMessage());
		}
	}

}
