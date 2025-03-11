class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        unordered_map<char, int> myMap;
        for(int i=0; i<order.length(); i++){
            myMap[order[i]] = i;
        }

        for(int i=0; i<words.size()-1; i++){
            string word1 = words[i];
            string word2 = words[i+1];
            int n = min(words[i].length(), words[i+1].length());
            bool isValid = false;

            for(int j=0; j<n; j++){
                if(myMap[word1[j]] < myMap[word2[j]]){
                    isValid = true;
                    break;
                }
                else if(myMap[word1[j]] > myMap[word2[j]]){
                    return false;
                }
            }
            if(!isValid && word1.size() > word2.size()){
            return false;
        }
        }
        return true;
    }
};