package getter_and_setter;

//6. Change Tracking
public class Observable {
	private String value;
    private List<Observer> observers = new ArrayList<>();
    
    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        notifyObservers(oldValue, value); // Notify listeners of change
    }
}
