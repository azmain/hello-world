import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "dvdf";
		int maxLength = lengthOfLongestSubstring(s);
		System.out.println(maxLength);
	}
	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		/*
		 * Using HashSet time complexity O(2n)
		 */
//		HashSet<Character> alphabets = new HashSet<Character>();
//		int i = 0,j = 0;
//		while(j < s.length()) {
//			if(!alphabets.contains(s.charAt(j))) {
//				alphabets.add(s.charAt(j));
//				j++;
//				maxLength = Math.max(maxLength, j-i);
//			}
//			else {
//				alphabets.remove(s.charAt(i));
//				i++;
//			}
//		}
		
		/*
		 * Using HashMap to reduce time complexity O(n)
		 */
		HashMap<Character,Integer> alphabet = new HashMap<Character,Integer>();
		for(int m = 0,n = 0; m < s.length(); m++) {   // pwwkew, dvdf
			if(alphabet.containsKey(s.charAt(m))) {
				n = Math.max(alphabet.get(s.charAt(m))+1,n);
			}
			maxLength = Math.max(maxLength, m-n+1);
			alphabet.put(s.charAt(m), m);
		}
		
		return maxLength;
	}
}
