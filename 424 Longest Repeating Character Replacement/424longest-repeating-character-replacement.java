class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i=0;
        int j=0;
        int maxFreq = 0;
        int maxLen = 0;

        while(j < s.length()){
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            while((j-i+1) - maxFreq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
                //recalculate maxFreq
                maxFreq = 0;
                for(int p=0; p<26; p++){
                    maxFreq = Math.max(maxFreq, freq[p]);
                }
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}