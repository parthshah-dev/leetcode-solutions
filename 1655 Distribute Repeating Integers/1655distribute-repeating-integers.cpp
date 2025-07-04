class Solution {
public:
    bool canDistribute_helper(vector<int>& count, vector<int>& quantity, int currPer){
        if(currPer >= quantity.size()){
            return true;
        }

        for(int i=0; i<count.size(); i++){
            if(count[i] >= quantity[currPer]){
                count[i] -= quantity[currPer];
                if(canDistribute_helper(count, quantity, currPer+1)){
                    return true;
                }
                count[i] += quantity[currPer];
            }
        }
        return false;
    }

    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        unordered_map<int,int>mp;
        for(auto num : nums){
            mp[num]++;
        }
        vector<int> freq;
        for(auto it=mp.begin(); it!=mp.end(); it++){
            freq.push_back(it->second);
        }
        sort(quantity.rbegin(), quantity.rend());

        return canDistribute_helper(freq, quantity, 0);
    }
};