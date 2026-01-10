class Solution {
    public static void reverse(int[] arr, int start_idx, int end_idx){
        while(start_idx < end_idx){
            swap(arr, start_idx, end_idx);
            start_idx++;
            end_idx--;
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int gola_index = -1;

        for(int i=n-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                gola_index = i-1;
                break;
            }
        }

        int swap_index = -1;
        if(gola_index != -1){
            for(int i=n-1; i>gola_index; i--){
                if(nums[i] > nums[gola_index]){
                    swap_index = i;
                    swap(nums, gola_index, swap_index);
                    break;
                }
            }
        }
        reverse(nums, gola_index + 1, n-1);
    }
}