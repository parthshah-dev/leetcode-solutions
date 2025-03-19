class Solution {
public:
    int compress(vector<char>& s) {
        int prev = s[0], count = 1, index = 0;
        for(int i=1; i<s.size(); i++){
            if(s[i] == prev){
                count++;
            }
            else{
                s[index++] = prev;
                if(count > 1){
                    string cnt = to_string(count);
                    for(char c : cnt){
                        s[index++] = c;
                    }
                }
                prev = s[i];
                count = 1;
            }
        }
        s[index++] = prev;
        if(count > 1){
            string cnt = to_string(count);
            for(char c : cnt){
                s[index++] = c;
            }
        }
        return index;
    }
};