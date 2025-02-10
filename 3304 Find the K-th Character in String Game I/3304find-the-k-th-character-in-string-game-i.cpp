class Solution {
public:
    char kthCharacter(int k) {
        string word = "a";
        while(word.size() < k){
            string newstr = word;
            for(int i=0; i<word.size(); i++){
                newstr += (word[i] == 'z' ? 'a' : word[i]+1); 
            }
            word = newstr;
        }
        return word[k-1]; 
    }
};