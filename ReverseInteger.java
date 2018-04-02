
public class ReverseInteger {
	public static void main(String[] args) {
		int num = 1534236469;
		int result = new ReverseInteger().reverseNumber(num);
		System.out.println(result);
	}
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
}
