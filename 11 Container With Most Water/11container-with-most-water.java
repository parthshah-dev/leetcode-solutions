class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = Integer.MIN_VALUE;

        while(left < right){
            int hght = Math.min(height[left], height[right]);
            int width = right - left;

            maxWater = Math.max(maxWater, hght*width);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}