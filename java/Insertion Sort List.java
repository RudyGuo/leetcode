//Sort a linked list using insertion sort.

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
	public ListNode insertionSortList(ListNode head) {
		if(head==null) return head;
		int insert = 0;
		ListNode nextLeft = head;
		while (true) {
			//left左边的node（包括left）是要被遍历插入的，right是要被插入的node
			ListNode left = nextLeft;
			if(left == null)    break;
			ListNode right = left.next;
			if (right == null)	break;
			ListNode rnext = right.next;
			//比头指针还小的情况
			if (right.val < head.val) {
				right.next = head;
				left.next = rnext;
				head = right;
				nextLeft = left;
				insert++;
				continue;
			}
			int index = insert;
			ListNode cur = head;
			ListNode next = head.next;
			//遍历寻找比被插入指针小的node，插入到该node的前一node的后面
			boolean change = false;
			while (index != 0) {
				if (right.val < next.val) {
					cur.next = right;
					right.next = next;
					left.next = rnext;
					nextLeft = left;
					change = true;
					break;
				}
				cur = cur.next;
				next = next.next;
				index--;
			}
			if(!change) nextLeft = left.next;
			insert++;
		}
		return head;
	}
}
