import java.util.LinkedList;

public class AddTwoNumbers {
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
//		l1.add(1);
		l1.add(2);
//		l1.add(4);
//		l1.add(3);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(9);
//		l2.add(6);
//		l2.add(4);
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3 = new AddTwoNumbers().add(l1,l2);
		System.out.println(l3);
	}
	
	public LinkedList<Integer> add(LinkedList<Integer> l1,LinkedList<Integer> l2) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		int carry = 0;
		while(l1.iterator().hasNext() && l2.iterator().hasNext()) {
//			System.out.println(l1.pop());
//			System.out.println(l2.pop());
			int num = ((int)l1.pop() + (int)l2.pop());
			int x = num % 10;
			x = x + carry;
			carry = num/10;
			result.add(x);
			//System.out.println(x);
		}
		while(l1.iterator().hasNext()) {
			int num = (int)l1.pop();
			int x = num % 10;
			x = x + carry;
			carry = num/10;
			result.add(x);
		}
		while(l2.iterator().hasNext()) {
			int num = (int)l2.pop();
			int x = num % 10;
			x = x + carry;
			carry = num/10;
			result.add(x);
		}
		if(carry != 0) {
			result.add(carry);
		}
		
		return result;
		
		/*
		 * Solution for leetcode
		 */
		/**
		 * Definition for singly-linked list.
		 * public class ListNode {
		 *     int val;
		 *     ListNode next;
		 *     ListNode(int x) { val = x; }
		 * }
		 */
//		class Solution {
//		    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		        ListNode dummy = new ListNode(0);
//		        ListNode result = dummy;
//		        int carry = 0;
//		        while(l1 != null && l2 != null){
//		            int x = l1.val + l2.val + carry;
//		            int num = x % 10;
//		            carry = x / 10;
//		            ListNode newNode = new ListNode(num);
//		            result.next = newNode;
//		            result = newNode;
//		            l1 = l1.next;
//		            l2 = l2.next;
//		        }
//		        while(l1 != null){
//		            int x = l1.val + carry;
//		            int num = x % 10;
//		            carry = x / 10;
//		            ListNode newNode = new ListNode(num);
//		            result.next = newNode;
//		            result = newNode;
//		            l1 = l1.next;
//		        }
//		        while(l2 != null){
//		            int x = l2.val + carry;
//		            int num = x % 10;
//		            carry = x / 10;
//		            ListNode newNode = new ListNode(num);
//		            result.next = newNode;
//		            result = newNode;
//		            l2 = l2.next;
//		        }
//		        if(carry != 0){
//		            ListNode newNode = new ListNode(carry);
//		            result.next = newNode;
//		            result = newNode;
//		        }
//		    
//		        
//		        return dummy.next;
//		    }
//		}
		
		
	}
}
