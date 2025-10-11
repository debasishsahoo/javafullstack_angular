package Mistakes.Mistake1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//GOOD - Returns defensive copy
public class GoodExample {
private List<String> items = new ArrayList<>();
    
    public List<String> getItems() {
        return new ArrayList<>(items);  // Returns a copy
    }
    
    // Or return unmodifiable view
    public List<String> getItemsView() {
        return Collections.unmodifiableList(items);
    }
}
