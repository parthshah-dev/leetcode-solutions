class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                int right = st.pop();
                int left = st.pop();
                st.push(left + right);
            }
            else if(s.equals("-")){
                int right = st.pop();
                int left = st.pop();
                st.push(left - right);
            }
            else if(s.equals("*")){
                int right = st.pop();
                int left = st.pop();
                st.push(left * right);
            }
            else if(s.equals("/")){
                int right = st.pop();
                int left = st.pop();
                st.push(left / right);
            }
            else{
                int num = 0;
                boolean isNegative = false;
                int start = 0;
                if(s.charAt(0) == '-') {
                    isNegative = true;
                    start = 1;
                }

                for(int i=start; i<s.length(); i++){
                    char c = s.charAt(i);
                    num = num * 10 + c - '0';
                }
                st.push(isNegative ? -num : num);
            }
        }

        return st.pop();
    }
}