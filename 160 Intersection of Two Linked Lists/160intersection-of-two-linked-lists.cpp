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
    int findLength(ListNode *head){
        ListNode *temp = head;
        int len  = 0;
        while(temp != nullptr){
            len++;
            temp = temp->next;
        }
        return len;
    }
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int len1 = findLength(headA); //length of LL 1
        int len2 = findLength(headB); //length of LL 2
        int diff = 0;
        if(len1 > len2){
            diff = len1-len2;
            while(diff--){
                headA = headA->next;
            }
        }else{
            diff = len2-len1;
            while(diff--){
                headB = headB->next;
            }
        }
        while(headA != nullptr && headB != nullptr){
            if(headA == headB){
                return headA;
            }
            headA = headA->next;
            headB = headB->next;
        }
        return nullptr;
    }
};