//Reverse a singly linked list.

//递归方法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
    	return reverseList(null, head);
    }
    
    private ListNode reverseList(ListNode left,ListNode right){
    	if(right==null) return left;
    	ListNode rnext = right.next;
    	right.next = left;
    	return reverseList(right,rnext);
    }
}

//迭代方法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
    	if(head==null) return head;
        ListNode leftHead = null;
        ListNode current = head;
        ListNode nxt = head.next;
        while(current!=null){
        	current.next = leftHead;
        	leftHead = current;
        	current = nxt;
        	if(current==null) break;
        	nxt = nxt.next;
        }
        return leftHead;
    }
}


