// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
        if(l1 == null&&l2 == null){  
            return null;  
        }  
        ListNode n1=l1;  
        ListNode n2 =l2;  
        ListNode node = new ListNode(0);  
        ListNode head = node;  
        int sum = 0;  
        while(n1 !=null||n2 != null){  
            if(n1!=null){  
                sum+=n1.val;  
                n1=n1.next;  
            }  
              
            if(n2!=null){  
                sum+=n2.val;  
                n2=n2.next;  
            }  
              
            node.next = new ListNode(sum%10);  
            node=node.next;  
            sum=sum/10;  
        }  
          
        if(sum==1){  
            node.next = new ListNode(1);;  
        }  
        return head.next;  
    }  
}  
