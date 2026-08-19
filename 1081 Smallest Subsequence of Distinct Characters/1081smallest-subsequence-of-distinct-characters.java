class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        boolean[] isPresent = new boolean[26];

        //store freq of chars
        for(int c : s.toCharArray()){
            freq[c-'a']++;
        }

        for(char c : s.toCharArray()){
            //if char already present in stack
            if(isPresent[c-'a'] == true){
                freq[c-'a']--;
                continue;
            }

            while(!st.isEmpty() && st.peek()>c && freq[st.peek()-'a']>0){
                isPresent[st.peek()-'a'] = false;
                st.pop();
            }
            st.push(c);
            freq[c-'a']--;
            isPresent[c-'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        for(char c : st){
            ans.append(c);
        }

        return ans.toString();
    }
}