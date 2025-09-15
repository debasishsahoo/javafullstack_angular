package Runtime_Polymorphism;

public class Motorcycle extends Vehicle{
	private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle engine is starting with kick/button...");
    }

    @Override
    public void maintenance() {
        System.out.println("Motorcycle maintenance: Chain lubrication, brake check");
    }
}
