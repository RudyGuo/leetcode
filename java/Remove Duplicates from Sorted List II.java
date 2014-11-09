/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
    ListNode res = new ListNode(0);
    res.next = head;
    ListNode ln = head;
    ListNode li = res;
    while(ln!=null){
    boolean dup = false;
    while(ln.next!=null&&ln.val == ln.next.val){
    ln = ln.next;
    dup = true;
    }
    if(dup){
    li.next = ln.next;
    
    }else{
    li = li.next;
    }
    ln = li.next;
    }
    return res.next;
    }
}
