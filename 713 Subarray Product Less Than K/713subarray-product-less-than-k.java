class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 1 || k == 0) return 0; //edge case

        int currProduct = 1;
        int count = 0;

        int i=0, j=0;
        while(j < nums.length){
            currProduct *= nums[j];

            while(i < nums.length && currProduct >= k){
                currProduct /= nums[i];
                i++;
            }

            count += j-i+1;
            j++;
            
        }
        return (count < 0) ? 0 : count;
    }
}