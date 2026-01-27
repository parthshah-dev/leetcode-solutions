class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int maxLength = 0;

        while(j < nums.length){
            if(nums[j] == 0){
                i = j+1;
            }else{
                maxLength = Math.max(maxLength, j-i+1);
            }
            j++;
        }
        return maxLength;
    }
}