class Solution {
public:
    //Time Complexity - O(n log n)
    
    int binarySearch(vector<int>nums, int start, int x){
        int end = nums.size()-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == x){
                return 1;
            }
            else if(nums[mid] > x){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return 0;
    }
    int findPairs(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        set<pair<int, int>>ans; //to store unique pair

        for(int i=0; i<nums.size()-1; i++){
            int x = nums[i]+k;
            if(binarySearch(nums, i+1, x)){
                ans.insert({nums[i], nums[i]+k});
            }
        }
        return ans.size();
    }
};