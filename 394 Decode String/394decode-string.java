class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != ']'){
                st.push(c);
            }else{
                StringBuilder repeat = new StringBuilder("");
                while(!st.isEmpty() && st.peek() != '['){
                    repeat.append(st.pop());
                }
                repeat.reverse();

                if(!st.isEmpty()){
                    st.pop(); //pop the '['
                }

                StringBuilder digit = new StringBuilder("");
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    digit.append(st.pop());
                }
                digit.reverse();
                
                int times = Integer.parseInt(digit.toString());
                String segment = repeat.toString();

                for(int i=0; i<times; i++){
                    for(char ch : segment.toCharArray()){
                        st.push(ch);
                    }
                }
            }

            
        }
        //Build the ans
            StringBuilder ans = new StringBuilder("");
            for(char p : st){
                ans.append(p);
            }

            return ans.toString();
    }
}