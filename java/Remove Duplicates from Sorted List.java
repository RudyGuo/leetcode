/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode res = new ListNode(0);
    	res.next = head;
    	ListNode ln = head;
    	ListNode li = res;
    	while(ln!=null){
    		boolean dup = false;
    		while(ln.next!=null&&ln.val == ln.next.val){
    			ln = ln.next;
    			dup = true;
    		}
    		if(dup){
    			li.next = ln;
    			
    		}else{
    			li = li.next;
    		}
    		ln = li.next;
    	}
    	return res.next;
    }
}

