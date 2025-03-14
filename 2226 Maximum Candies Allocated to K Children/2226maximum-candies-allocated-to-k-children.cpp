class Solution {
public:
    bool isPossibleSoln(int mid, vector<int>& candies, long long k){
        long long stud = 0;
        for(int i=0; i<candies.size(); i++){
            stud += candies[i] / mid;

            if(stud >= k) return true;
        }
        return false;
    }
    int maximumCandies(vector<int>& candies, long long k) {
        long long totalCandies = accumulate(candies.begin(), candies.end(), 0LL); 
        if(k > totalCandies) return 0;

        int ans = 0;

        sort(candies.begin(), candies.end());

        int start = 1, end = *max_element(candies.begin(), candies.end());
        while(start <= end){
            int mid = start + (end - start)/2;

            if(isPossibleSoln(mid, candies, k)){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
};