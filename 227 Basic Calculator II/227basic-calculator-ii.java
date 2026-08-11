class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char prevOp = '+';
        int num = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if(prevOp == '+'){
                    st.push(num);
                }
                else if(prevOp == '-'){
                    st.push(-num);
                }
                else if(prevOp == '*'){
                    int prev = st.pop();
                    st.push(prev * num);
                }
                else if(prevOp == '/'){
                    int prev = st.pop();
                    st.push(prev / num);
                }

                prevOp = c;
                num = 0;
            }
        }

        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}