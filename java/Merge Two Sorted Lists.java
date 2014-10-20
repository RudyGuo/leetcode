/*Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode head = new ListNode(0);
        ListNode res=head;
        while(h1!=null&&h2!=null){
        	if(h1.val<h2.val){
        		head.next = h1;
        		head = head.next;
        		h1 = h1.next;
        	}else{
        		head.next = h2;
        		head = head.next;
        		h2 = h2.next;
        	}
        }
        if(h1==null){
        	head.next = h2;
        }else{
        	head.next = h1;
        }
        return res.next;
    }
}
