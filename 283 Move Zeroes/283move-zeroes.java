class Solution {
    public void moveZeroes(int[] nums) {
        int fillIdx = 0;

        for(int j=0; j<nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[fillIdx];
                nums[fillIdx] = nums[j];
                nums[j] = temp;

                fillIdx++;
            }
        }
    }
}