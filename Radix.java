import java.util.*;
import java.lang.*;

public class Radix {

	public static void main(String[] args) {
		
	}

	private static int getDigit(int val, int column) {
		String fake = "" + val;
		char digit = fake.charAt(fake.length()-(1+column));
		int dig = Character.getNumericValue(digit);
		return dig;
	}

	public static void radixsort(int[]data) {

	}
}