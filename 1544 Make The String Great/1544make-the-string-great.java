class Solution {
    public String makeGood(String s) {
        if(s.length() == 1) return s;

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            
            //Case 1: Character is in uppercase
            if(c == Character.toUpperCase(c)){
                if(!st.isEmpty() && st.peek() == Character.toLowerCase(c)){
                    st.pop();
                    continue;
                }
            }else{ //Case 2: Character is in lowercase
                if(!st.isEmpty() && st.peek() == Character.toUpperCase(c)){
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}