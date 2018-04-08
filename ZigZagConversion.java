

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "ABC";
		/*
		 * PAYPALISHIRING
		 * 
		 * P   A   H   N
		 * A P L S I I G
		 * Y   I   R
		 * 
		 * PAHNAPLSIIGYIR
		 */
		int n = 2;
		String result = new ZigZagConversion().convert(s,n);
		System.out.println(result);
	}
	public String convert(String s, int numRows) {
		if(s == null || numRows <= 1 || s.length() < numRows) {
			return s;
		}
		int length = s.length();
		char[] letters = new char[length];
		int count = 0;
		int columnDistance = 2*numRows - 2;
		/*
		 * columnDistance and middleElementDistance are two important observation here
		 */
		// loop through the rows
		for(int i = 0; i < numRows; i++) {
			//System.out.print(s.charAt(i));
			int middleElement = columnDistance - 2 * i;
			// loop through the columns
			for(int j = i; j < length; j += columnDistance) {
				//System.out.print(s.charAt(j));
				letters[count++] = s.charAt(j);
				// loop through the middle elements. 
				// here the last condition is for edge case when end of the string
				if(middleElement > 0 && middleElement < columnDistance && j+middleElement < length) {
					//System.out.println(s.charAt(j+step));
					letters[count++] = s.charAt(j+middleElement);
				}
			}
		}
		return new String(letters);
    }
}
