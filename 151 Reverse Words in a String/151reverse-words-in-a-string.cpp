class Solution {
public:
    string reverseWords(string s) {
        int n = s.length();
        int i=0;

        reverse(s.begin(), s.end());

        while(s[n-1] == ' '){ //remove trailing spaces
            n--;
        }
        while(s[i] == ' '){ //remove heading spaces
            i++;
        }

        string ans = "";

        while(i < n){
            string word = "";
            while(i < n && s[i] != ' '){
                word += s[i];
                i++;
            }
            reverse(word.begin(), word.end());
            ans += " " + word;

            while(i < n && s[i] == ' '){ //skip spaces between words
                i++;
            }
        }

        return ans.substr(1);
    }
};