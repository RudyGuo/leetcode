// Swap Nodes in Pairs

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
    public ListNode swapPairs(ListNode head) {
    	if(head == null||head.next == null){
    		return head;
    	}
    	ListNode res = head.next;
    	ListNode left = head;
    	ListNode right = head.next;
    	while(true){
    		ListNode ln = right.next;
    		right.next = left;
    		if(ln==null){
    			left.next =null;
    			break;
    		}
    		if(ln.next!=null){
    			left.next = ln.next;
    		}else{
    			left.next = ln;
    			break;
    		}
            left =ln;
    		right = ln.next;
    	}
    	return res;
    }
}

/* 其他：
As you can see, the addition of an empty node at the start removes the problem of "head" being a special case, 
as the start of the list is now defined as "what follows start," and the middle of the list is easy to swap.
As we also know that start is not null, cur is not null at the beginning, and checking cur.next.next during 
the while loop means it cannot be null in following loops. If cur.next is null, then the condition short circuits 
to false before needing to evaluate to a nullpointerexception. Therefore, the conditions at the start are unneeded. */

public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode start = new ListNode(0); //make head no longer a special case
    start.next = head;

    for(ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
      cur.next = swap(cur.next, cur.next.next);        
    }
    return start.next;
  }
  private Listnode swap(ListNode next1, ListNode next2) {
    next1.next = next2.next;
    next2.next = next1;
    return next2;
  }
}