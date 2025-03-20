class Solution {
public:
    string convert(string s, int numRows) {

        if(numRows == 1) return s;

        vector<string> zigzag(numRows);

        int row = 0, step = 1; //T -> B
        for(char c : s){
            zigzag[row].push_back(c);
            if(row == 0) step = 1;
            if(row == numRows-1) step = -1;
            row += step;
        }
        
        string ans = "";
        for(int i=0; i<zigzag.size(); i++){
            ans += zigzag[i];
        }
        return ans;
    }
};