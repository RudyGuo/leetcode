/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode head(-1);
		ListNode *cursor = &head;
		int tp =0;
		while(l1!=nullptr||l2!=nullptr){
			int x = l1!=nullptr?l1->val:0;
			int y = l2!=nullptr?l2->val:0;
			tp += x+y;
			cursor->next = new ListNode(tp%10);
			//ListNode ln(tp%10);
			//cursor->next = &ln;
			cursor= cursor->next;
			if(l1!=nullptr) l1 = l1->next;
			if(l2!=nullptr) l2 = l2->next;
			tp /= 10;
		}
		if(tp!=0){
			cursor->next = new ListNode(tp);
		}
		return head.next;
	}
};