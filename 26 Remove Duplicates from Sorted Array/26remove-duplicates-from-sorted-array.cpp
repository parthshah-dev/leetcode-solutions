class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = 1;
        int left = 0;
        int right = 1;
        while(right < nums.size()){
            if(nums[right] != nums[left]){
                nums[++left] = nums[right];
                length++;
            }
            right++;
        }
        return length;
    }
};