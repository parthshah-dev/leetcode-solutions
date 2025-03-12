class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int posNums = 0;
        int negNums = 0;
        for(int i=0; i<nums.size(); i++){
            if(nums[i] == 0) continue;
            else if(nums[i] < 0){
                negNums++;
            }
            else{
                posNums++;
            }
        }
        return max(posNums, negNums);
    }
};