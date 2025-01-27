class Solution {
public:
    void subsequence(vector<int>& arr, int index, int n, vector<vector<int>>& ans,  vector<int>& temp){
        //Base case
        if(index == n){
            ans.push_back(temp);
            return;
        }
        //Skip the elment
        subsequence(arr, index+1, n, ans, temp);

        //add element in the current set
        temp.push_back(arr[index]);
        subsequence(arr, index+1, n, ans, temp);
        temp.pop_back();
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>ans; //2D array to store all sets
        vector<int>temp; //Array to store current set
        subsequence(nums, 0, nums.size(), ans, temp);

        return ans;
    }
};