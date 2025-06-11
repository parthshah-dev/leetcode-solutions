class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> ans;
        if(nums.size() == 1){
            ans.push_back(nums[0]);
            return ans;
        }

        unordered_map<int, int>mp;
        for(int i : nums){
            mp[i]++;
        }
        
        //Min-heap of pairs {frequency, element}
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> minHeap;
        for(auto it=mp.begin(); it!=mp.end(); it++){
            minHeap.push({it->second, it->first});
            if(minHeap.size() > k){
                minHeap.pop();
            }
        }

        //extract top k elements
        while(!minHeap.empty()){
            ans.push_back(minHeap.top().second);
            minHeap.pop();
        }
        return ans;
    }
};