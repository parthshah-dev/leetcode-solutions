class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int actual_sum = 0;
        int total_sum = n*(n+1) / 2;
        for(int i=0; i<n; i++){
            actual_sum += nums[i];
        }
        return total_sum - actual_sum;
    }
};