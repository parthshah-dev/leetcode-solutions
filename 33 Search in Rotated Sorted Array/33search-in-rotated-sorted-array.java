class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int ans = -1;

        while(left <= right){
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                break;
            }

            //mid lies on line 1
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }

            //mid lies on line 2
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        } 
        return ans;

    }
}