package utils;

public class MathUtil {

	/**
	 * Rounds a decimal value to the specified position.
	 *
	 * @param value  the decimal value provided
	 * @param places the decimal place that the number will be rounded to
	 * @return		 The number rounded to the specified position
	 */
	public static double round(double value, int places) {
		return Math.round(value * (Math.pow(10, places))) / (Math.pow(10, places));
	}

	/**
	 * Generates a random random number in the defined range.
	 *
	 * @param min the the lowest possible limit of the range
	 * @param max the highest possible limit of the range
	 * @return	  A random number within the range
	 */
	public static int random(int min, int max) {
		return (int) ((Math.random() * ((max + 1) - min)) + min);
	}

	/**
	 * Determines if given value is a prime number.
	 *
	 * @param num the given number to be tested
	 * @return	  Whether the given number is a prime number
	 */
	public static boolean boolPrimeNum(int num) {
		boolean flag = false;
		for (int i = 2; i <= num/2; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (!flag) return true;
		else return false;
	}
}