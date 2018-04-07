

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "ccc";
		String result = new LongestPalindromicSubstring().longestPalindrome(s);
		//boolean result = new LongestPalindromicSubstring().isPalindrome(s);
		System.out.println(result);
	}
	
	/*
	 * Brute force method
	 * It takes much time O(n^2)
	 */
//	public String longestPalindrome(String s) {
//		if(s.length() <= 1000) {
//			String result = "";
//			for(int i = 0; i < s.length(); i++) {
//				for(int j = i; j < s.length(); j++) {
//					//System.out.println(s.substring(i, j+1));
//					String sub = s.substring(i, j+1);
//					if(isPalindrome(sub)) {
//						result = result.length()<sub.length()?sub:result;
//					}
//				}
//				
//			}
//			return result;
//		}
//		throw new IllegalArgumentException();
//	}
//	public boolean isPalindrome(String s) {
//		int end = s.length()-1;
//		int start = 0;
//		while(start <= end) {
//			if(s.charAt(start) != s.charAt(end)) {
//				return false;
//			}
//			start++;
//			end--;
//		}
//		return true;
//	}
	
	/*
	 * Dynamic approach - divide the problem into smaller sub task and solve each part only once
	 * 
	 */
	public String longestPalindrome(String s) {
		/*
		 * if string is null or one alphabet
		 */
		if(s == null || s.length() < 2) {
			return s;
		}
		int length = s.length();
		/*
		 * if string length if more than two
		 * start and end are for holding the final length of longest string
		 */
		int start = 0;
		int end = 0;
		// holding the truth and false values
		boolean[][] matrix = new boolean[length][length];
		// here i is the right and j is left
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < i; j++) {
				boolean isPalindrome = matrix[j+1][i-1] || i-j <= 2;
				if(s.charAt(i) == s.charAt(j) && isPalindrome) {
					matrix[j][i] = true;
					
					// update the start and end if substring length is higher
					if(i-j > end-start) {
						start = j;
						end = i;
					}
				}
			}
		}
		return s.substring(start, end+1);
	}
}
