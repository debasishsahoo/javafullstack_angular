package AdvancedConcepts1;

//Concrete implementation
public class SportsCar extends Car{
	@Override
    void accelerate() {
        System.out.println("Sports car accelerating rapidly!");
    }
    
    @Override
    void brake() {
        System.out.println("Sports car braking with ABS!");
    }
}
