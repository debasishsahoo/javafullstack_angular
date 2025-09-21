
interface Electric {
    void charge();
}
//Abstract class
abstract class Appliance {
 String name;

 Appliance(String name) {
     this.name = name;
 }

 abstract void turnOn();

 void turnOff() {
     System.out.println(name + " is turned off.");
 }
}



public class AbstractDemo3 {
	public static void main(String[] args) {}
}
