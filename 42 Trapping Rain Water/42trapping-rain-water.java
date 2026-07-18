class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int left = 0;
        int right = height.length-1;

        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += rightMax - height[right];
                right--;
            }
        }
        return trappedWater;
    }
}