class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = "";
        int maxLen = strs[0].length();

        for(int i=0; i<maxLen; i++){
            char currC = strs[0][i];
            for(int j=1; j<strs.size(); j++){
                if(currC != strs[j][i]){
                    return ans;
                }
            }
            ans += currC;
        }
        return ans;
    }
};