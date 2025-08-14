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
    ListNode* findMid(ListNode* head){
        if(!head || !head->next) return head;

        ListNode* fast = head->next;
        ListNode* slow = head;
        while(fast && fast->next){
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow;
    }
    ListNode* merge(ListNode* first, ListNode* second){
        ListNode* mgptr = new ListNode(-1);
        ListNode* newHead = mgptr;

        while(first && second){
            if(first->val < second->val){
                mgptr->next = first;
                mgptr = first;
                first = first->next;
            }
            else{
                mgptr->next = second;
                mgptr = second;
                second = second->next;
            }
        }
        if(first){
            mgptr->next = first;
        }
        if(second){
            mgptr->next = second;
        }
        return newHead->next;
    }
    ListNode* mergeSort(ListNode* head){
        if (!head || !head->next) return head;

        ListNode* mid = findMid(head);

        //divide the linked list in from mid
        ListNode* first = head;
        ListNode* second = mid->next;
        mid->next = nullptr;

        ListNode* left = mergeSort(first);
        ListNode* right = mergeSort(second);

        return merge(left, right);
    }
    ListNode* sortList(ListNode* head) {
        return mergeSort(head);
    }
};