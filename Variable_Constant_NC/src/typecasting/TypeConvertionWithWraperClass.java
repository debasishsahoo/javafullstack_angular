package typecasting;

public class TypeConvertionWithWraperClass {

	public static void main(String[] args) {
		// String to primitive conversion
		String str = "123";
		int num = Integer.parseInt(str);
		double dbl = Double.parseDouble("45.67");
		boolean bool = Boolean.parseBoolean("true");

		// Primitive to String conversion
		String s1 = Integer.toString(500);
		String s2 = Double.toString(78.9);
		String s3 = String.valueOf(true);

		// Conversion between wrapper types
		Integer intObj = 42;
		Double doubleObj = intObj.doubleValue();  // 42.0
		Float floatObj = intObj.floatValue();     // 42.0f

	}

}
