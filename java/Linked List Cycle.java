/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

利用快慢指针
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
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow!=null&&fast!=null&&fast.next!=null){
			if(slow ==fast) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
