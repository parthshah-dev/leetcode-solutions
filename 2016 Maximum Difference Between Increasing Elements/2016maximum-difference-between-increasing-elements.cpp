class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int ans = -1, mini = nums[0];
        for(int i=0; i<nums.size(); i++){
            ans = max(ans, nums[i] - mini);
            mini = min(mini, nums[i]);
        }
        return ans==0 ? -1 : ans;
    }
};