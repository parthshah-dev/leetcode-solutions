class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int open = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }
            else if(c == ')'){
                if(open > 0){
                    open--;
                }else{
                    continue;
                }
            }
            temp.append(c);
        }

        int close = 0;
        for(int i=temp.length()-1; i>=0; i--){
            char c = temp.charAt(i);

            if(c == ')'){
                close++;
            }
            else if(c == '('){
                if(close > 0){
                    close--;
                }else{
                    continue;
                }
            }
            ans.append(c);
        }

        return ans.reverse().toString();
    }
}