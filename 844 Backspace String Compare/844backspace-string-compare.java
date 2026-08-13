class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(c);
            }
        }

        int skip = 0;

        for(int i=t.length()-1; i>=0; i--){
            char c = t.charAt(i);

            if(c == '#'){
                skip++;
            }
            else if(skip > 0){
                skip--;
            }
            else{
                if(st.isEmpty() || st.pop() != c) return false;
            }
        }
        return st.isEmpty();
    }
}