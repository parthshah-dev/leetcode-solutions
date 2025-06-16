class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> ans;
        unordered_map<int, int>mp;
        int count = nums.size() / 3;

        for(int num : nums){
            mp[num]++;
        }

        for(auto it = mp.begin(); it != mp.end(); it++){
            if(it->second > count){
                ans.push_back(it->first);
            }
        }
        return ans;
    }
};