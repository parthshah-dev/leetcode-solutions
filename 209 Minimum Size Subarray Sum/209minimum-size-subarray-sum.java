class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int i=0;
        int j=0;

        while(j < nums.length){
            sum += nums[j];

            while(sum >= target){
                len = Math.min(len, j-i+1);
                sum -= nums[i];
                i++;
            }

            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}