class Solution {
public:
    //implementation of custom comparator to decide order
    static bool mycomp(string a, string b){
        return a+b > b+a;
    }
    string largestNumber(vector<int>& nums) {
        vector<string> s;
        for(int n : nums){
            s.push_back(to_string(n));
        }    

        sort(s.begin(), s.end(), mycomp);

        if(s[0] == "0") return "0";

        string ans = "";
        for(string curr : s){
            ans += curr;
        }
        return ans;
    }
};