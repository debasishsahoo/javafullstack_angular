package AccessModifiers.PrivateFolder.AccessingPrivateMembers;
//Using Public/Protected Accessor Methods

//1 . Only Use Protected in Same Class
class Parent {
	private String secret = "Confidential";

	// Protected method to access private field
	protected String getSecret() {
		return secret;
	}

	// Protected method to modify private field
	protected void setSecret(String value) {
		this.secret = value;
	}

}

//2. We can Use Public in Drive Class
class Child extends Parent {

	public void accessSecret() {
		// Accessing Parent's private field indirectly via protected method
		String value = getSecret();
		System.out.println("Secret: " + value);
	}

	public void modifySecret(String newSecret) {
		// Modifying Parent's private field indirectly via protected method
		setSecret(newSecret);
		System.out.println("Secret modified!");
	}
}

public class ProtectedAccessDemo {

	public static void main(String[] args) {
		Child child = new Child();
		// Access the secret
        child.accessSecret(); 
        
        // Modify the secret
        child.modifySecret("New Confidential Data");
        
        // Access again to confirm change
        child.accessSecret(); 
	}

}

//- `secret` is **private** in `Parent`, so it **cannot be accessed directly** in `Child`.
//- `getSecret()` and `setSecret()` are **protected**, so `Child` can use them to **read and modify** the private field.
