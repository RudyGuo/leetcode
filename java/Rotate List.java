/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/

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
    public ListNode rotateRight(ListNode head, int n) {  
        if(head==null) return head;  
        ListNode ln = head;  
        ListNode last = null;  
        ListNode res = null;  
        int len = 0;  
        while (ln.next != null) {  
            ln = ln.next;  
            len++;  
        }  
        len++;  
        int k = len-(n%(len));  
        if(k==0||k==len) return head;  
        ListNode ln2 = head;  
        int seq = 0;  
        while (ln2.next != null) {  
            seq++;  
            if (seq == k){  
                last = ln2;  
                break;  
            }  
            ln2=ln2.next;  
        }  
        ln.next = head;  
        res=last.next;  
        last.next=null;  
        return res;  
    }  
}  
