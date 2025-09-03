package Hybrid_Inheritance;

class ElectricAutonomousCar extends Vehicle implements ElectricPowered, AutonomousDriving {
    private int batteryCapacity;
    private boolean autopilotEnabled;
    
    public ElectricAutonomousCar(String manufacturer, int year, int batteryCapacity) {
        super(manufacturer, year);
        this.batteryCapacity = batteryCapacity;
        this.autopilotEnabled = false;
    }
    
     // Implementation of ElectricPowered interface methods
    @Override
    public void chargeBattery() {
        System.out.println(manufacturer + " electric car is charging");
    }
    @Override
    public int getBatteryCapacity() {
        return batteryCapacity;
    }
    
    // Implementation of AutonomousDriving interface methods
    @Override
    public void enableAutopilot() {
        autopilotEnabled = true;
        System.out.println(manufacturer + " autopilot engaged");
    }
    
    @Override
    public void calibrateSensors() {
        System.out.println("Calibrating LiDAR and camera sensors");
    }
    
    // Override parent class method
    @Override
    public void startEngine() {
        System.out.println(manufacturer + " electric motor initializing silently");
    }
    
     // New method specific to this class
    public void displayTechSpecs() {
        displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Autopilot Status: " + (autopilotEnabled ? "Engaged" : "Disabled"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
