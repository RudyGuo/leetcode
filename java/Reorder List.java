/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

基本思想：从链表中间这段，对后一段的链表作reverse，然后间隔插入到前一段的链表中。
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
	public void reorderList(ListNode head) {
		if(head == null) return;
		ListNode ln = head;
		int len = 0;
		while(ln!=null){
			len++;
			ln = ln.next;
		}
		int mid = (len-1)/2;
		ListNode midNode = head;
		while(mid!=0){
			midNode = midNode.next;
			mid--;
		}
		ListNode insert = reverse(midNode.next);
		midNode.next = null;
		ListNode bInsert = head;
		while(insert!=null){
			ListNode inext = insert.next;
			ListNode bnext = bInsert.next;
			bInsert.next = insert;
			insert.next = bnext;
			bInsert = bnext;
			insert = inext;
		}
	}
	
	private ListNode reverse(ListNode head){
		ListNode pre = null;
		ListNode cur = head;
		while(cur!=null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
