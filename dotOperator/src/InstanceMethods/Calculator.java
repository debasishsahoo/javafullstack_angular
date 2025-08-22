package InstanceMethods;

public class Calculator {
	 private double result;
	 
	 public double add(double a, double b) {
	        result = a + b;
	        return result;
	    }
	 public double getResult() {
	        return result;
	    }
	 public void reset() {
	        result = 0;
	    }
}
