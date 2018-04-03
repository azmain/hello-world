
public class PalindromeNumber {
	public static void main(String[] args) {
		int number = 123221;
		boolean result = new PalindromeNumber().isPalindrome(number);
		System.out.println(result);
	}
	public boolean isPalindrome(int x) {
		if(x < 0 || (x != 0 && x % 10 == 0)){
			return false;
		}
//		int result = reverseNumber(x);
//		if(result == x) {
//			return true;
//		}
//		else {
//			return false;
//		}
		boolean result = halfReverseNumber(x);
		return result;
	}
	/*
	 * reversing full number takes much time
	 */
	public int reverseNumber(int num) {
		int result = 0;
		int rem;
		while(num != 0) {
			rem = num%10;
			int temp = result*10+rem;
			if(temp/10 != result) {
				return 0;
			}
			result = temp;
			num = num/10;
		}
		return result;
	}
	/*
	 * reversing half number takes less time
	 */
	public boolean halfReverseNumber(int num) {
		int reverseNumber = 0;
		/*
		 * how do we know that we have reached the half of the number?
		 * then reverse number will be equal or greater than the main number
		 * as we divide the main number by 10 and multiplying the reverse number by 10
		 */
		while(num > reverseNumber) {
			reverseNumber = reverseNumber * 10 + (num % 10);
			num /= 10;
		}
		/*
		 * reverseNumber / 10 == num
		 * this is for when main number is 12321
		 * number after dividing 12
		 * reverse number after multiplying 123
		 * middle number doesn't matter
		 */
		return reverseNumber == num || reverseNumber / 10 == num;
	}
}
