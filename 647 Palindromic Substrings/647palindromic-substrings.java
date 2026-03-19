class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count = n;

        for(int i=0; i<s.length(); i++){
            //odd length palindrome
            int l=i-1;
            int r=i+1;

            while((l>=0 && r<n) && (s.charAt(l) == s.charAt(r))){
                count++;
                l--;
                r++;
            }

            //even length palindrome
            l=i;
            r=i+1;

            while((l>=0 && r<n) && (s.charAt(l) == s.charAt(r))){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}