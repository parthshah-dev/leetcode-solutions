class Solution {
public:
    void removeRE(string& s, string& part){
        int pos = s.find(part);
        //base case
        if(pos == string::npos){
            return;
        }
        else{
            s.erase(pos, part.size());
            
            //recursive call
            removeRE(s, part);
        }
    }
    string removeOccurrences(string s, string part) {
        /*int pos = s.find(part);

        while(pos != string::npos){
            s.erase(pos, part.size());
            pos = s.find(part);
        }
        return s; */

        removeRE(s, part);
        return s;
    }
};