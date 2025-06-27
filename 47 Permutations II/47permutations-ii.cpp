class Solution {
public:
void Permutations(vector<int>& nums, vector<vector<int>>& ans, int start){
        if(start >= nums.size()){
            ans.push_back(nums);
            return;
        }
        unordered_set<int> seen;
        for(int i=start; i<nums.size(); i++){
            if(seen.count(nums[i])){
                continue;
            }
            seen.insert(nums[i]);
            swap(nums[i], nums[start]);
            Permutations(nums, ans, start+1);
            swap(nums[i], nums[start]);
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>>ans;
        Permutations(nums, ans, 0);
        return ans;
    }
};