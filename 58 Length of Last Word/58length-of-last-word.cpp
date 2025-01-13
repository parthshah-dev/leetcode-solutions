class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.size();
        int length = 0;
        int start = n-1;

        while(start >=0 && s[start] == ' '){
            start--;
        }
        for(int i=start; i>=0; i--){
            if(s[i] == ' '){
                break;
            }
            length++;
        }
        return length;
    }
};