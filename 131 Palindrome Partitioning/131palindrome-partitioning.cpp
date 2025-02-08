class Solution {
public:
    bool isPalindrome(string& temp){
        int start = 0, end = temp.size()-1;
        while(start <= end){
            if(temp[start] != temp[end]){
                return false;
            }
            start++, end--;
        }
        return true;
    }
    void findPart(string& s, vector<vector<string>>& ans, vector<string>& temp, int index){
        //Base case
        if(index == s.size()){
            ans.push_back(temp);
            return;
        }

        for (int i = index; i < s.size(); i++) {
            string sub = s.substr(index, i - index + 1);
            if(isPalindrome(sub)){
                temp.push_back(sub); 
                findPart(s, ans, temp, i + 1); 
                temp.pop_back();  
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>>ans;
        vector<string> temp;
        if(s.empty()){
            return ans;
        }
        else{
            findPart(s, ans, temp, 0);
        }
        return ans;
    }
};