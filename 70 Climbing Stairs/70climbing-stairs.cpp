class Solution {
public:
    int climbStairs(int n) {
        int i = 0, j = 1, ans = 0;
        for(int k=0; k<n; k++){
            ans = i + j;
            i = j;
            j = ans;
        }
        return ans;
    }
};