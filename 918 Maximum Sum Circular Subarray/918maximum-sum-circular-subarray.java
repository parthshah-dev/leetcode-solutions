class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSubarraySum = Integer.MIN_VALUE;
        int minSubarraySum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];

            currentMax = Math.max(currentMax+nums[i], nums[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currentMax);

            currentMin = Math.min(currentMin+nums[i], nums[i]);
            minSubarraySum = Math.min(minSubarraySum, currentMin);
        }

        if(maxSubarraySum < 0) return maxSubarraySum;

        int circularSum = totalSum-minSubarraySum;
        return Math.max(maxSubarraySum, circularSum);
    }
}