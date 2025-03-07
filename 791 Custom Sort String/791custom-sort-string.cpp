class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> orderMap;

        //store the char order of 'order' string
        for(int i=0; i<order.length(); i++){
            orderMap[order[i]] = i;
        }

        //Sort based on index in orderMap
        sort(s.begin(), s.end(), [&](char a, char b){
            return orderMap[a] < orderMap[b];
        });

        return s;
    }
};