class Solution {
public:
    int myAtoi(string s) {
        int startInd = 0;
        int sign = 1;
        int ans = 0;

        //determining the starting index to traverse if the string contains any leading spaces
        while(startInd < s.length() && s[startInd] == ' '){
            startInd++;
        }

        //determine the sign, if negative then store and move index ahead
        if(startInd < s.length() && (s[startInd] == '-' || s[startInd] == '+')){
            sign = s[startInd] == '-' ? -1 : 1;
            startInd++;
        }

        while(startInd < s.length() && isdigit(s[startInd])){
            if(s[startInd] == ' '){
                continue;
            } 
            else{
                //checking overflow
                if (ans > (INT_MAX - (s[startInd] - '0')) / 10) {
                    return (sign == 1 ? INT_MAX : INT_MIN);
                }
                ans = ans * 10 + (s[startInd] - '0');
            }
            startInd++;
        }

        return ans * sign;
    }
};