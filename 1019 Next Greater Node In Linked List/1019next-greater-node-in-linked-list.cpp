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
    void LLtoArray(ListNode* head, vector<int>& arr){
        ListNode* temp = head;
        while(temp){
            arr.push_back(temp->val);
            temp = temp -> next;
        }
    }
    vector<int> nextLargerNodes(ListNode* head) {
        vector<int>arr;
        LLtoArray(head, arr);
        vector<int> ans(arr.size());

        stack<int>st;
        for(int i=ans.size()-1; i>=0; i--){
            while(!st.empty() && st.top() <= arr[i]){
                st.pop();
            }
            if(st.empty()) ans[i] = 0;
            else{
                ans[i] = st.top();
            }
            st.push(arr[i]);
        }
        return ans;
    }
};