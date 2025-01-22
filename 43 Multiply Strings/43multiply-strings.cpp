class Solution {
public:
    string multiply(string num1, string num2) {
        int n = num1.size();
        int m = num2.size();

        if(num1 == "0" || num2 == "0"){
            return "0";
        }
        vector<int> result(m + n, 0);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num2[i] - '0') * (num1[j] - '0');
                int sum = product + result[i + j + 1]; // Add current product to the current position

                result[i + j + 1] = sum % 10;          // Update the current digit
                result[i + j] += sum / 10;            // Add carry to the next position
            }
        }
        //Convert vector to string
        string ans;
        bool leadzero = true;
        for(int i=0; i<result.size(); i++){
            if(leadzero && result[i] == 0){
                continue; //continue until the first non zero digit is encountered
            }
            leadzero = false; //first non zero digit is encountered
            ans += to_string(result[i]);
        }
        return ans.empty() ? "0" : ans;
    }
};