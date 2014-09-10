/* Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

核心：reverseNode() 将k个链表倒叙 */


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
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = new ListNode(0);
		start.next = head;
		boolean flag = false;
		for (ListNode cur = start;; cur = kNode(cur, k)) {
			for (int i = 1; i <= k; i++) {
				if (kNode(cur, i) == null) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
			cur.next = reverseNode(cur.next, k);
		}

		return start.next;

	}

	private ListNode kNode(ListNode node, int k) {
		ListNode ln = node;
		for (int i = 0; i < k; i++) {
			ln = ln.next;
		}
		return ln;
	}

	private ListNode reverseNode(ListNode left, int k) {
		ListNode ln = kNode(left,k-1).next;
		ListNode res = kNode(left,k-1);
		for(int i=k-1;i>0;i--){
			kNode(left,i).next = kNode(left,i-1);
		}
		left.next = ln;
		return res;
	}

}