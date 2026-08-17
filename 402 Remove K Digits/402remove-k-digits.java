class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";

        Stack<Character> st = new Stack<>();

        for(char c : num.toCharArray()){
            while(!st.isEmpty() && st.peek() > c && k > 0){
                st.pop();
                k--;
            }
            st.push(c);
        }

        if(k != 0){
            while(k > 0){
                st.pop();
                k--;
            }
        }

        StringBuilder ans = new StringBuilder();
        boolean isLeadingZero = true;
        for(char c : st){
            if(isLeadingZero && c == '0'){
                continue;
            }
            isLeadingZero = false;
            ans.append(c);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}