package Hybrid_Inheritance;

interface ElectricPowered {
	void chargeBattery();
    int getBatteryCapacity();
    
    default void displayEcoFriendlyMessage() {
        System.out.println("This is an eco-friendly vehicle");
    }
    
    
    
    
}
