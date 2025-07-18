class Solution {
public:
    bool isPossibleSoln(vector<int>& nums, int& k, int& mid){
        int count = 1;
        int currSum = 0;
        for(int i=0; i<nums.size(); i++){
            if(currSum + nums[i] <= mid){
                currSum += nums[i];
            }else{
                currSum = nums[i];
                count++;
                if(count > k){
                    return false;
                }
            }
        }
        return true;
    }
    int splitArray(vector<int>& nums, int k) {
        int start = INT_MIN;
        int end = 0, mid, result;
        for(int num : nums){
            end += num;
            start = max(start, num);
        }

        while(start <= end){
            mid = start+(end-start)/2;

            if(isPossibleSoln(nums, k, mid)){
                result = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }
};