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
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int>ans = {-1, -1};
        // Less than 4 nodes → at most 1 critical point → answer always {-1, -1}
        if (!head || !head->next || !head->next->next || !head->next->next->next) 
            return ans;

        ListNode* prev = head;
        ListNode* curr = head->next;
        ListNode* nxt = head->next->next;

        int firstCP = -1;
        int prevCP = -1;
        int index = 1; //start from curr node
        int minDistance = INT_MAX;

        while(nxt){
            bool isCP = ((curr->val < prev->val && curr->val < nxt->val) || (curr->val >    prev->val && curr->val > nxt->val)) ? true : false;

            if(isCP){
                if(firstCP == -1){
                    firstCP = index;
                } 
                else{
                    minDistance = min(minDistance, index - prevCP);
                    ans[1] = index - firstCP; //update max distance continously
                }
                prevCP = index;
            }
            prev = curr;
            curr = nxt;
            nxt = nxt->next;
            index++;
        }
        if(minDistance != INT_MAX) ans[0] = minDistance;
        return ans;
    }
};