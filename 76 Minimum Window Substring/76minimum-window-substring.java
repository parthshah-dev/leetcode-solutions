class Solution {
    static boolean allPresent(Map<Character, Integer> tMap, Map<Character, Integer>sMap){
        for (char c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true; 
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int i=0; 
        int j=0;
        
        int start=0;
        int minLen=Integer.MAX_VALUE;

        while(j < s.length()){
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);

            while(allPresent(tMap, sMap)){
                if(j-i+1 < minLen){
                    start=i;
                    minLen=j-i+1;
                }

                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                i++;   
            }

            j++;
        }

        return minLen==Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}