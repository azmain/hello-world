
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		double median = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1,nums2);
		System.out.println(median);
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		// takes the shortest array
		if(nums1.length>nums2.length) {
			return findMedianSortedArrays(nums2,nums1);
		}
		
		// length of both arrays
		int x = nums1.length;
		int y = nums2.length;
		
		// work with shortest array
		int start = 0;
		int end = x;
		
		// logis starts
		while(start <= end) {
			
			// partition both arrays
			int partitionX = (start + end)/2;
			int partitionY = ((x + y + 1)/2) - partitionX;
			
			// left side maximum & right side minimum of array nums1 consequently
			int minX = partitionX == 0?Integer.MIN_VALUE:nums1[partitionX-1];
			int maxX = partitionX == x?Integer.MAX_VALUE:nums1[partitionX];
			
			// left side maximum & right side minimum consequently of array num2 consequently
			int minY = partitionY == 0?Integer.MIN_VALUE:nums2[partitionY-1];
			int maxY = partitionY == y?Integer.MAX_VALUE:nums2[partitionY];
			
			if(minX <= maxY && minY <= maxX) {
				if((x+y)%2 == 0){
					return ((double)(Math.max(minX, minY)+Math.min(maxX, maxY)))/2.0;
				}
				else {
					return (double)(Math.max(minX, minY));
				}
			}
			else if(minX > maxY) {
				end = partitionX - 1;
			}
			else {
				start = partitionX + 1;
			}
		}
		
		throw new IllegalArgumentException();
	}
}
