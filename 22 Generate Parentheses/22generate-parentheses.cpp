class Solution {
public:
    void generateParenthesis_helper(vector<string>& ans, int open, int close, string& temp){
        if(open==0 && close==0){
            ans.push_back(temp);
            return;
        }

        //include open bracket
        if(open > 0){
            temp.push_back('(');
            generateParenthesis_helper(ans, open-1, close, temp);
            temp.pop_back();
        }

        //include closing bracket
        if(close > open){
            temp.push_back(')');
            generateParenthesis_helper(ans, open, close-1, temp);
            temp.pop_back();
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string>ans;
        string temp = "";

        generateParenthesis_helper(ans, n, n, temp);

        return ans;
    }
};