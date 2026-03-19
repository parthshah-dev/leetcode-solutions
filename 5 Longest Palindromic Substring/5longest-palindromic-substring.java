class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        int n=s.length();

        for(int i=0; i<s.length(); i++){
            //odd length palindrome
            int l=i-1;
            int r=i+1;

            while((l>=0 && r<n) && (s.charAt(l) == s.charAt(r))){
                if(r-l+1 > maxLen){
                    start=l;
                    maxLen=r-l+1;
                }
                l--;
                r++;
            }

            //even length palindrome
            l=i;
            r=i+1;

            while((l>=0 && r<n) && (s.charAt(l) == s.charAt(r))){
                if(r-l+1 > maxLen){
                    start=l;
                    maxLen=r-l+1;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start + maxLen);
    }
}