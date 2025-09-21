
public class Main {
	public static void main(String[] args) {
		Vehicle car = new Car("Toyota", 2022);
		Vehicle bike = new Bike("Yamaha", 2023);

		car.showDetails();
		car.start();

		bike.showDetails();
		bike.start();
	}
}