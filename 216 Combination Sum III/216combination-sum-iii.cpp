class Solution {
public:
    void findCom(int k, int n, vector<vector<int>>& ans, vector<int>& temp, int index){
        if(temp.size() == k){
            if(n == 0){
                ans.push_back(temp);
            }
            return;
        }
        for(int i=index; i<=9; i++){
            temp.push_back(i);
            findCom(k, n-i, ans, temp, i+1);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<int> temp;
        vector<vector<int>> ans;
        findCom(k, n, ans, temp, 1);
        return ans;
    }
};