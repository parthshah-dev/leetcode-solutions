class Solution {
public:
    static bool mycomp(pair<char, int>& a, pair<char, int>& b){
        return a.second > b.second;
    }
    string frequencySort(string s) {
        unordered_map<char, int>map;
        //store the frequency of each character
        for(char c : s){
            map[c]++;
        }
        
        //vector to store the character and their frequency for sorting
        vector<pair<char,int>>v(map.begin(), map.end());

        //sort the vector
        sort(v.begin(), v.end(), mycomp);

        //store in ans
        string ans = "";

        for(int i=0; i<v.size(); i++){
            ans += string(v[i].second, v[i].first); //append the char frequency number of times
        }

        return ans;
    }
};