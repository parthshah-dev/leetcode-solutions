class Solution {
public:
    int KMP_Match(string haystack, string needle){
        vector<int> lps(needle.size(), 0);
        int pre = 0, suff = 1;

        while(suff < needle.size()){
            if(needle[suff] == needle[pre]){
                lps[suff] = pre + 1;
                pre++, suff++;
            }
            else{
                if(pre == 0){
                    suff++;
                }
                else{
                    pre = lps[pre - 1];
                }
            }
        }

        //KMP code

        int first = 0, second = 0;
        while(first < haystack.size() && second < needle.size()){
            if(haystack[first] == needle[second]){
                first++, second++;
            }
            else{
                if(second == 0){
                    first++;
                }
                else{
                    second = lps[second - 1];
                }
            }
        }

        if(second == needle.size()){
            return 1;
        }
        return 0;
    }

    int repeatedStringMatch(string a, string b) {
        string temp = a;
        int repeat = 1;
        while(temp.size() < b.size()){
            temp += a;
            repeat++;
        }
        if(KMP_Match(temp, b) == 1){
            return repeat;
        }
        if(KMP_Match(temp+a, b) == 1){
            return repeat+1;
        }

        return -1;
    }
};