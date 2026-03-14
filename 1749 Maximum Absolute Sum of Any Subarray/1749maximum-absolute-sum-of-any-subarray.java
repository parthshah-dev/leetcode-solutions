class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currSumMax = nums[0];
        int currSumMin = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSumMax = Math.max(currSumMax + nums[i], nums[i]);
            maxSum = Math.max(currSumMax, maxSum);
            
            currSumMin = Math.min(currSumMin + nums[i], nums[i]);
            minSum = Math.min(currSumMin, minSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}