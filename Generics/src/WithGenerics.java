import java.util.ArrayList;
import java.util.List;

public class WithGenerics {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		// list.add(100); // Compile-time error

		String s = list.get(0); // No cast required
		System.out.println(s);
	}

}
//Type safety
//Eliminates casting
//Detects errors at compile-time