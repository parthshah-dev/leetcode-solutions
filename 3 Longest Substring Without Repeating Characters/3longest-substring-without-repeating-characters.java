class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int j=0; 
        int i=0;

        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while(map.get(s.charAt(j)) > 1){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }

            len = Math.max(len, j-i+1);
            j++;
        }
        return len;
    }
}