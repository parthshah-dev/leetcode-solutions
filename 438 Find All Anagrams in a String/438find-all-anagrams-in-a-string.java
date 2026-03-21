class Solution {
    public static boolean matches(int[] p, int[] s){
        for(int i=0; i<26; i++){
            if(p[i] != s[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int j=0;
        int i=0;
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        //store p freq
        for(char c : p.toCharArray()){
            pFreq[c - 'a']++;
        }
        
        while(j<s.length()){
            sFreq[s.charAt(j) - 'a']++;

            if(j-i+1 == p.length()){
                if(matches(pFreq, sFreq)){
                    ans.add(i);
                }

                sFreq[s.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }
        return ans;
    }
}