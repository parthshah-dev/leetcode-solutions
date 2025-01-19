class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        
        //Placing all the elements of array on their correct indices
        for(int i=0; i<n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1]!=nums[i]){
                swap(nums[i], nums[nums[i]-1]);
            }
        }
        int missing = 1;
        for(int i=0; i<n; i++){
            if(nums[i] == missing)
                missing++;
        }
        return missing;
    }
};