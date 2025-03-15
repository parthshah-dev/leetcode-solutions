class Solution {
public:
    bool isIsomorphic(string s, string t) {
        vector<int> hash(256, 0); //to hash the s[i] to t[i]
        vector<bool> istCharMapped(256, 0); //to check whether t[i] already mapped

        //mapping chars and updating hash and istCharMapped
        for(int i=0; i<s.length(); i++){
            if(hash[s[i]] == 0 && istCharMapped[t[i]] == 0){
                hash[s[i]] = t[i];
                istCharMapped[t[i]] = true;
            }
        }

        //check whether hashing done properly
        for(int i=0; i<s.length(); i++){
            if(hash[s[i]] != t[i]){
                return false;
            }
        }
        return true;
    }
};