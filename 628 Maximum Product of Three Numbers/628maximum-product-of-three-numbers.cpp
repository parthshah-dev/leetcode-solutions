class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        //product of largest three positive
        int pro1 = nums[nums.size()-1] * nums[nums.size()-2] * nums[nums.size()-3];

        //product of smallest two and largest positive to handle negative case
        int pro2 = nums[0] * nums[1] * nums[nums.size()-1];

        return (long long)max(pro1, pro2);
    }
};