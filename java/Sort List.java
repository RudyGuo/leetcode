/*
Sort a linked list in O(n log n) time using constant space complexity.
利用Merge Sort
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode fast = head,slow = head;
    	while(fast!=null&&fast.next!=null&&fast.next.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	fast = slow;
    	slow = slow.next;
    	fast.next = null;
    	ListNode left = sortList(head);
    	ListNode right = sortList(slow);
    	return merge(left,right);
    }
    
    
    private ListNode merge(ListNode left,ListNode right){
    	ListNode dummy = new ListNode(-1);
    	ListNode sc = dummy;
    	while(left!=null&&right!=null){
    		if(left.val<right.val){
    			sc.next = left;
    			left = left.next;
    		}else{
    			sc.next = right;
    			right = right.next;
    		}
    		sc = sc.next;
    	}
    	if(left!=null){
    		sc.next = left; 
    	}else{
    		sc.next = right;
    	}
    	return dummy.next;
    }
}


