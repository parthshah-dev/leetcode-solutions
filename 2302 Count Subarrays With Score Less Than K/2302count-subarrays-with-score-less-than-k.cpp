class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        long long count = 0;
        long long score = 0;
        long long sum = 0;
        long long n = nums.size();


        int i=0, j=0;

        while(j < n){
            sum += nums[j];
            while(i<=j && sum * (j-i+1) >= k){ //shrink window
                sum -= nums[i];
                i++;
            }
            count += (j-i+1);
            j++;
        }

        return count;
    }
};