class Solution {
public:
    bool isPowerOf2(int n){
        return (n > 0) && (n & (n-1)) == 0;
    }

    bool reorder(string& s, int start){
        if(start >= s.size()){
            return s[0] != '0' && isPowerOf2(stoi(s));
        }

        for(int i=start; i<s.size(); i++){
            swap(s[start], s[i]);
            if(reorder(s, start+1)){
                return true;
            }
            swap(s[start], s[i]);
        }

        return false;
    }

    bool reorderedPowerOf2(int n) {
        string str = to_string(n);

        if(str.size()==1 && isPowerOf2(n)){
            return true;
        }
        return reorder(str, 0);
    }
};