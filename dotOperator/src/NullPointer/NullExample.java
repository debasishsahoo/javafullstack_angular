package NullPointer;

import java.util.Optional;
public class NullExample {

	public static void main(String[] args) {
		String str =null;
		
		try {
			int length = str.length(); // NullPointerException
		} catch (NullPointerException e) {
			System.out.println("Cannot use dot operator on null reference!");
		}
		
		
		// Safe approach
		if (str != null) {
			int length = str.length();
			System.out.println("Length: " + length);
		}

		
		// Using Optional (Java 8+)
		Optional<String> optionalStr = Optional.ofNullable(str);
		optionalStr.ifPresent(s -> System.out.println("Length: " + s.length()));
	}

}
