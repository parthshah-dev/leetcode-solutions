class Solution {
public:
    string reversePrefix(string word, char ch) {
        string ans;
        int n = word.size();
        int i=0;

        while(i < n && word[i] != ch){
            ans += word[i];
            i++;
        }
        if(i == n){
            return word;
        }
        ans += word[i];
        reverse(ans.begin(), ans.end());

        for(int j = i+1; j<n; j++){
            ans += word[j];
        }
        return ans;
    }
};