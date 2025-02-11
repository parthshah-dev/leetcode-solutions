class Solution {
public:
    vector<int> findWays(string exp){
        vector<int> ans;
        //check if the given only a number
        bool isNum = true;
        for(char c : exp){
            if(!isdigit(c)){
                isNum = false;
                break;
            }
        }

        if(isNum){
            ans.push_back(stoi(exp));
            return ans;
        }

        for(int i=0; i<exp.size(); i++){
            char op = exp[i];

            if(op == '+' || op == '-' || op == '*'){
                vector<int> left = findWays(exp.substr(0, i));
                vector<int> right = findWays(exp.substr(i+1));

                for(int l : left){
                    for(int r : right){
                        if(op == '+') ans.push_back(l+r);
                        else if(op == '-') ans.push_back(l-r);
                        else if(op == '*') ans.push_back(l*r);
                    }
                }
            }
        }
        return ans;
    }
    vector<int> diffWaysToCompute(string expression) {
        return findWays(expression);
    }
};