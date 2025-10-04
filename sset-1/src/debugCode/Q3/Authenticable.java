package debugCode.Q3;

//Interface for payment methods that require authentication
public interface Authenticable {
	 boolean authenticate(String credential);
	 void setAuthToken(String token);
}
