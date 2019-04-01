public class Radix {

	public static void main(String[] args) {
		System.out.println(""+getDigit(123,1));
	}

	private int getDigit(int val, int column) {
		int modulizer = 10 ** column;
		return val % modulizer;
	}

	public static void radixsort(int[]data) {

	}
}