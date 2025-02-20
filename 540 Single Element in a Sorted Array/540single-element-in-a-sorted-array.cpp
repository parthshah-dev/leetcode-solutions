class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int start = 0;
        int end = nums.size()-1;
        int ans;
        while(start <= end){
            int mid = start + (end-start)/2;
            //return the single element present
            if(start == end){
                ans = nums[start];
                break;
            } 

            //case-1: if mid is at even index
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    start = mid+2;
                }
                else{ 
                    end = mid;
                }
            }
            //case-2: if mid is at odd index
            else{
                if(nums[mid] == nums[mid-1]){
                    start = mid+1;;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return ans;
    }
};