package operators;

public class BitwiseOperators {

	public static void main(String[] args) {
		int a = 5;  // Binary: 0101
		int b = 3;  // Binary: 0011

		int bitwiseAND = a & b;    // Bitwise AND: 0001 (decimal: 1)
		int bitwiseOR = a | b;     // Bitwise OR: 0111 (decimal: 7)
		int bitwiseXOR = a ^ b;    // Bitwise XOR: 0110 (decimal: 6)
		int bitwiseComplement = ~a; // Bitwise Complement: 1111...1010 (decimal: -6)
		
		

		// Shift operators
		int leftShift = a << 1;    // Left shift: 1010 (decimal: 10)
		int rightShift = a >> 1;   // Right shift: 0010 (decimal: 2)
		int unsignedRightShift = a >>> 1; // Unsigned right shift: 0010 (decimal: 2)


	}

}
