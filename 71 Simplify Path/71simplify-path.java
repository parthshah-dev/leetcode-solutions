class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        int i=0;

        while(i < path.length()){
            while(i < path.length() && path.charAt(i) == '/'){
                i++;
            }

            StringBuilder token = new StringBuilder("");

            while(i < path.length() && path.charAt(i)!= '/'){
                token.append(path.charAt(i));
                i++;
            }

            String dir = token.toString();

            if(dir.equals("") || dir.equals(".")){
                continue;
            }
            else if(dir.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(dir);
            }
        }
        
        //Build ans
        if(st.isEmpty()) return "/";
        
        StringBuilder res = new StringBuilder("");
        
        for(String str : st){
            res.append("/").append(str);
        }

        return res.toString();
    }
}