/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if(m == n) return head;
        ListNode cur = dummy;
        for(int i=0;i<m-1;i++){
        	cur = cur.next;
        }
        
        ListNode head2 = cur;
        ListNode pre = head2.next;
        cur = pre.next;
        for(int i=m;i<n;i++){
        	ListNode lin = head2.next;
        	head2.next = cur;
        	pre.next = cur.next;
        	cur.next = lin;
        	cur = pre.next;
        }
        return dummy.next;
    }
}




