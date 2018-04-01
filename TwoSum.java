import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class TwoSum {
	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5};
		int target = -8;
		int[] result = new TwoSum().twoSum(nums,target);
		System.out.println(result[0]+","+result[1]);
	}
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		/*
		 * More time complex O(n^2)
		 */
//        for(int i = 0; i < nums.length; i++) {
//        		for(int j = i+1; j < nums.length; j++) {
//        			if(nums[i]+nums[j] == target) {
//        				result[0] = i;
//        				result[1] = j;
//        				break;
//        			}
//        		}
//        }
		/*
		 * better solution using hashmap O(n)
		 */
		HashMap<Integer,Integer> checked = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(checked.containsKey(target-nums[i])) {
				result[0] = checked.get(target-nums[i]);
				result[1] = i;
			}
			checked.put(nums[i], i);
		}
        return result;
    }
}
