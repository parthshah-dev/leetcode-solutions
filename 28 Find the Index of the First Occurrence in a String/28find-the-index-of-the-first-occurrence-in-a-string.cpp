class Solution {
public:
    int strStr(string haystack, string needle) {
        if(haystack.length() < needle.length()) return -1;

        /*
        int posIndex = -1;
        int i=0, j=0;

        while(i<haystack.length() && j<needle.length()){
            if(haystack[i] == needle[j]){
                if(posIndex == -1){
                    posIndex = i;
                }
                j++;

                if(j == needle.length()) return posIndex;
            }
            else{
                if(posIndex != -1){
                    i = posIndex;
                }
                j=0;
                posIndex = -1;
            }
            i++;
        }
        return -1;
        */

        //sliding window
        int n = haystack.length();
        int m = needle.length();

        for(int i=0; i<=n-m; i++){
            for(int j=0; j<m; j++){
                if(needle[j] != haystack[i+j]){
                    break;
                }
                if(j == m-1) return i;
            }
        }
        return -1;
    }
};