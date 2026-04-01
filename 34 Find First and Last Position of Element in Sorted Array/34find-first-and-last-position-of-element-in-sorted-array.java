class Solution {
    public static int findLastIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int last = -1;

        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target){
                last=mid;
                left=mid+1;
            }
            else if(nums[mid] > target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return last;
    }
    public static int findFirstIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int first = -1;

        while(left <= right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target){
                first=mid;
                right=mid-1;
            }
            else if(nums[mid] > target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return first;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = findFirstIndex(nums, target);

        if(firstIdx == -1) return new int[]{-1,-1};

        int lastIdx = findLastIndex(nums, target);

        return new int[]{firstIdx, lastIdx};
    }
}