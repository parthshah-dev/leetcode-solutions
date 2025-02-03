class Solution {
public:
    void findSub(vector<int>& nums, vector<vector<int>>& ans, vector<int>& temp, int index, int n){
        ans.push_back(temp);

        for(int i=index; i<n; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            temp.push_back(nums[i]);
            findSub(nums, ans, temp, i+1, n);
            temp.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int>temp;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        findSub(nums, ans, temp, 0, n);
        return ans;
    }
};