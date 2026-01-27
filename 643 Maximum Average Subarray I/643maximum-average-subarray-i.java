class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        int i=0;
        int j=0;

        //find the very first window average
        while(j < k){
            sum += nums[j];
            j++;
        }
        double maxAvg = sum / k;

        while(j < nums.length){
            sum -= nums[i];
            sum += nums[j];
            maxAvg = Math.max(maxAvg, sum / k);
            i++;
            j++;
        }
        return maxAvg;
    }
}