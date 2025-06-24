class Solution {
public:
    void findCom(vector<int>& candidates, int target, int index, vector<vector<int>>& ans, vector<int>& temp){
        if(target == 0){
            ans.push_back(temp);
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=index; i<candidates.size(); i++){
            temp.push_back(candidates[i]);
            findCom(candidates, target-candidates[i], i, ans, temp);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans; 
        vector<int> temp;
        int n = candidates.size();
        findCom(candidates, target, 0, ans, temp);
        return ans;
    }
};