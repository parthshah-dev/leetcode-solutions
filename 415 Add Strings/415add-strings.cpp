class Solution {
public:
    void finalAdd(string& num1, string& num2, int i, int j, int carry, string& ans){
        //base case
        if(i < 0 && j < 0){
            if(carry){
                ans += string(1, carry + '0');
            }
            return;
        }

        //ek case ham solve karenge
        int n1 = (i >=0) ? num1[i] - '0' : 0;
        int n2 = (j >=0) ? num2[j] - '0' : 0;
        int sum = n1 + n2 + carry;
        int digit = sum % 10;
        carry = sum / 10;
        ans += (digit + '0');

        //recursive call
        finalAdd(num1, num2, i-1, j-1, carry, ans);
    }
    string addStrings(string num1, string num2) {
        if(num1 == "0" && num2 == "0") return "0";

        string ans = "";
        int lenA = num1.length();
        int lenB = num2.length();
        finalAdd(num1, num2, lenA-1, lenB-1, 0, ans);
        reverse(ans.begin(), ans.end());
        return ans;        
    }
};