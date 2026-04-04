class Solution {
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if(nums.length == 1) return;

        //step 1: Reverse entire array
        reverse(nums, 0, nums.length-1);

        //step 2: Reverse first k elements
        reverse(nums, 0, k-1);

        //step 3: Reverse remaining elements
        reverse(nums, k, nums.length-1);
    }
}