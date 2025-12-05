class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> ans(nums.size(), 0);
        int left = 0;
        int right = nums.size()-1;
        int i = nums.size()-1;
        while(left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if(leftSq > rightSq){
                ans[i] = leftSq;
                left++;
            }else{
                ans[i] = rightSq;
                right--;
            }
            i--;
        }
        return ans;
    }
};