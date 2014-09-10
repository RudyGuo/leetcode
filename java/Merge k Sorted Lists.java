// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// 分治法

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
	public ListNode mergeKLists(List<ListNode> lists) {
		int size = lists.size();
		if(size == 0){
	        return null;
	    }</span><span style="color:#333333;">
		if (size == 1) {
			return lists.get(0);
		}
		int mid = (size - 1) / 2 + 1;
		ListNode ln1 = mergeKLists(lists.subList(0, mid));
		ListNode ln2 = mergeKLists(lists.subList(mid, size));
		return mergeNode(ln1,ln2);
	}
	public ListNode mergeNode(ListNode one, ListNode two) {
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (one!=null&&two!=null) {
			if (one.val < two.val) {
				p.next = one;
				p = p.next;
				one = one.next;
			} else {
				p.next = two;
				p = p.next;
				two = two.next;
			}
		}
		while(two!=null){
			p.next = two;
			two = two.next;
			p = p.next;
		}
		while(one !=null){
			p.next = one;
			one = one.next;
			p = p.next;
		}
		return head.next;
	}
}

// 方法二

public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> pque = new PriorityQueue<>(10,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});
		for (int i = 0; i < lists.size(); i++) {
			ListNode ln = lists.get(i);
			if (ln != null) {
				pque.offer(ln);
			}
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(!pque.isEmpty()){
			ListNode n = pque.poll();
			p.next = n;
			p =p.next;
			if(n.next!=null){
				pque.offer(n.next);
			}
		}
		return head.next;
	}
}