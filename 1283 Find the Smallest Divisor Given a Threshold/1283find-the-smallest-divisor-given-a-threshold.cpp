class Solution {
public:
    bool isPossibleSoln(int mid, vector<int>& nums, int threshold){
        int sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum += ceil((double) nums[i] / mid);
        }
        return sum <= threshold;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        int start = 1, end = *max_element(nums.begin(), nums.end());
        int ans = 1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(isPossibleSoln(mid, nums, threshold)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
};