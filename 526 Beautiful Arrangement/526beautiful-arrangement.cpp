class Solution {
public:
    void countArrangement_helper(int &ans, vector<int> &temp, int &n, int currNum){
        if(currNum == n+1){
            ans++;
            return;
        }

        //try placing current number
        for(int i=1; i<=n; i++){
            if(temp[i] == 0 && (currNum % i == 0 || i % currNum == 0)){
                temp[i] = currNum;
                countArrangement_helper(ans, temp, n, currNum+1);
                temp[i] = 0;
            }
        }
    }
    int countArrangement(int n) {
        vector<int>temp(n+1);
        int ans = 0;
        countArrangement_helper(ans, temp, n, 1);

        return ans;
    }
};