package Mistakes.Mistake1;

import java.util.ArrayList;
import java.util.List;

//BAD - Exposes internal state
//Mistake 1: Returning Mutable Objects
public class BadExample {
	private List<String> items = new ArrayList<>();

	public List<String> getItems() {
		return items; // Caller can modify the internal list!
	}
}
