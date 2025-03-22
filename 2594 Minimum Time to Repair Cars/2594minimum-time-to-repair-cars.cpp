class Solution {
public:
    bool isPossibleSoln(long long mid, vector<int>& ranks, int cars){
        long long carsRepaired = 0;

        for(int i=0; i<ranks.size(); i++){
            carsRepaired += sqrt(mid / ranks[i]);
        }
        return carsRepaired >= cars;

    }
    long long repairCars(vector<int>& ranks, int cars) {
        long long ans = -1;
        long long start = 1; //minimum time
        long long maxR = *max_element(ranks.begin(), ranks.end());
        long long end = 1LL * maxR * cars * cars; //maximum time

        while(start <= end){
            long long mid = start + (end - start)/2;

            if(isPossibleSoln(mid, ranks, cars)){
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