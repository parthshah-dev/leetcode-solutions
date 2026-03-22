class Solution {
    static boolean matches(int[] s1, int[] s2){
        for(int i=0; i<s1.length; i++){
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int i=0;
        int j=0; 
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int k=0; k<s1.length(); k++){
            s1Freq[s1.charAt(k)-'a']++;
        }

        while(j < s2.length()){
            s2Freq[s2.charAt(j) - 'a']++;

            if(j-i+1 == s1.length()){
                if(matches(s1Freq, s2Freq)){
                    return true;
                }
                s2Freq[s2.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }
        return false;
    }
}