package algo;

import java.text.DecimalFormat;
/**
 * This program finds the square root of a number
 * without using any library function
 * using binary search
 * @author Azmain
 *
 */
public class squareRoot {
	public static void main(String[] args) {
		sqrt(5);
		sqrtWithPrecision(5,10);
	}
	/**
	 * finds the best possible square root of number
	 * @param number
	 */
	public static void sqrt(int number) {
		float precision = 0.0001f;
		float start = 0;
		float end = number;
		float middle = start;
		float difference = (float) Math.abs((Math.pow(middle, 2)-number));
		//System.out.println(difference);
		while(difference > precision) {
			middle = (start+end)/2;
			if(Math.pow(middle, 2)> number) {
				end = middle;
			}
			else {
				start = middle;
			}
			difference = (float) Math.abs((Math.pow(middle, 2)-number));
		}
		System.out.println(middle);
	}
	/**
	 * finds the square root of a number upto a precision
	 * @param number
	 * @param precision
	 */
	public static void sqrtWithPrecision(int number,int precision) {
		int start = 0;
		int end = number;
		double ans = 0.0;
		int mid = 0;
		/**
		 * calculates the integral part
		 */
		while(start <= end) {
			mid = (start+end)/2;
			if(mid*mid == number) {
				ans = mid;
				break;
			}
			if(mid*mid < number) {
				start = mid+1;
				ans = mid;
			}
			else {
				end = mid-1;
			}
		}
		/**
		 * calculates the fractional part
		 */
		double increment = 0.1;
		for(int i = 0; i < precision; i++) {
			while(ans*ans <= number) {
				ans += increment;
			}
			ans -= increment;
			increment /= 10;
		}
		// Float can print upto 6 decimal point precision
		System.out.println((float)ans);
		
		// Double can print upto 14 decimal point precision
		DecimalFormat df2 = new DecimalFormat("#.0000000000");
		System.out.println(df2.format(ans));
		
	}
}
