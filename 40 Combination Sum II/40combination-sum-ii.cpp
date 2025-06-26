class Solution {
public:
    void find(vector<int>& candidates, vector<int>& temp, vector<vector<int>>& ans, int target, int index){
        if(target == 0){
            ans.push_back(temp);
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=index; i<candidates.size(); i++){
            //skip duplicates
            if(i > index && candidates[i] == candidates[i-1]) continue;

            temp.push_back(candidates[i]);
            find(candidates, temp, ans, target - candidates[i], i + 1);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> temp;
        sort(candidates.begin(), candidates.end());
        find(candidates, temp, ans, target, 0);
        return ans;
    }
};