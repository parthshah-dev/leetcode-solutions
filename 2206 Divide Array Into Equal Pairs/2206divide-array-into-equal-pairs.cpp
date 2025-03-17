class Solution {
public:
    bool divideArray(vector<int>& nums) {
        int maxTerm = *max_element(nums.begin(), nums.end());

        vector<int>hash(maxTerm + 1);
        for(int i=0; i<nums.size(); i++){
            hash[nums[i]]++;
        }

        //check if the occurance of each value is even, if not return false
        for(int i=0; i<hash.size(); i++){
            if(hash[i] % 2 == 1){
                return false;
            }
        }
        return true;
    }
};