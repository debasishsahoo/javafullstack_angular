package getter_and_setter;

import java.util.List;
import java.util.Observer;

//6. Change Tracking
public class Observable {
	private String value;
    private List<Observer> observers = new ArrayList<>();
    
    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        notifyObservers(oldValue, value); // Notify listeners of change
    }

	private void notifyObservers(String oldValue, String value2) {
		// TODO Auto-generated method stub
		
	}
}
