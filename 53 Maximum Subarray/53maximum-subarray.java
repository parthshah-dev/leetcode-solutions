class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;

        for(int i=0; i<nums.length; i++){
            runningSum = Math.max(runningSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}