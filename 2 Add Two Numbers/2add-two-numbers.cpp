/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* head1, ListNode* head2) {
        ListNode* ansHead = new ListNode(-1);
        ListNode* ansTail = ansHead;


        //Perform addition of each node and store carry, if generated
        int carry = 0;

        while(head1 != nullptr && head2 != nullptr){
            int sum = carry + head1->val + head2->val;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode* newNode = new ListNode(digit);

            ansTail->next = newNode;
            ansTail = newNode;
            
            head1 = head1->next;
            head2 = head2->next;
        }

        while(head1 != nullptr){
            int sum = carry + head1->val;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode* newNode = new ListNode(digit);

            ansTail->next = newNode;
            ansTail = newNode;

            head1 = head1->next;
        }
        while(head2 != nullptr){
            int sum = carry + head2->val;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode* newNode = new ListNode(digit);

            ansTail->next = newNode;
            ansTail = newNode;

            head2 = head2->next;
        }
        if(carry){
            ListNode* newNode = new ListNode(carry);

            ansTail->next = newNode;
            ansTail = newNode;
        }
        ansTail->next = nullptr;

        return ansHead->next;
    }
};