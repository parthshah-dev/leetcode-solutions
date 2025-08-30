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
    ListNode* mergeNodes(ListNode* head) {
        if(!head) return nullptr;

        ListNode* ans = new ListNode(0); 
        ListNode* mptr = ans;
        ListNode* temp = head->next; //skip head as it is 0
        int sum = 0;

        while(temp){
            if(temp->val == 0){
                ListNode* newNode = new ListNode(sum);
                mptr->next = newNode;
                mptr = newNode;
                sum = 0;
            }
            else{
                sum += temp->val;
            }
            temp = temp->next;
        }
        return ans->next;
    }
};