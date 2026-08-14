class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for(char c : s.toCharArray()){
            if(c == ' ') continue;

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            else if(c == '+'){
                result += num*sign;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += num*sign;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                st.push(result);
                st.push(sign);

                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += num*sign;

                int prevSign = st.pop();
                int prevNum = st.pop();

                result = prevNum + result * prevSign;

                sign = 1;
                num = 0;
            }
        }
        result += num * sign;

        return result;
    }
}