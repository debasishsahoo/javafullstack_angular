import java.util.ArrayList;
import java.util.List;

public class WithoutGenerics {

	public static void main(String[] args) {
		List list = new ArrayList(); // raw type
		list.add("Hello");
		list.add(100); // allowed, but unsafe

		String s = (String) list.get(0); // OK
		String num = (String) list.get(1); // ClassCastException at runtime

	}

}
