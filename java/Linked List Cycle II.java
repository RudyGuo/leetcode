/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

首先设圆环的长度为r，距离环口为a时相遇，环外的那一段的距离是b,那么有2（a+b）=a+b+nr ,n>1;
所以有a+b = nr；   进一步有 b+ pr = （r-a）+qr，即从头指针和当前相遇位置的指针以相同速度移动一定在环口位置相遇
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
	public ListNode detectCycle(ListNode head) {
		if(head==null) return null;
		ListNode slow2 = head;
		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;
		while(fast!=null&&fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;			
			if(slow == fast) {
				isCycle =  true;
				break;
			}
		}
		if(isCycle){
			while(slow2!=slow){
				slow = slow.next;
				slow2 = slow2.next;
			}
			return slow;
		}else{
			return null;
		}
	}
}
Linked List Cycle II