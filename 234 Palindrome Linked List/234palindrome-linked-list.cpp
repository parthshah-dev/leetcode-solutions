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
    ListNode* reverseLL(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* next = curr->next;

        while(curr != nullptr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        if(head->next == nullptr){
            return true;
        }
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast != nullptr && fast->next != nullptr){
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode* temp1 = head;
        ListNode* temp2 = reverseLL(slow);

        while(temp2 != nullptr){
            if(temp1->val != temp2->val){
                return false;
            }
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        return true;
    }
};