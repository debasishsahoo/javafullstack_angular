import java.util.List;
import java.util.ArrayList;

public class UserManager {
	// Constant collection
	private static final int MAX_LOGIN_ATTEMPTS = 3;

	public static void main(String[] args) {
		// Using var (Java 10+)
		var userList = new ArrayList<String>(); // Inferred as ArrayList<String>
		
		userList.add("");
		userList.add("Alice");
		userList.add("Bob");
		
		// Process users
		int activeUsers = processUsers(userList);
		System.out.println("Active: " + activeUsers + "/" + userList.size());
	}

	private static int processUsers(List<String> users) {
		int count = 0;            // Local variable
		
		for (var user : users){    // Type inference in loop
			if (!user.isBlank())
				count++;
		}
		return count;
	}

}
