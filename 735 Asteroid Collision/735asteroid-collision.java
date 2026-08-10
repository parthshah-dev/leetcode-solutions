class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int n : asteroids){

            boolean isAlive = true;

            if(n > 0){
                st.push(n);
            }else{
                while(!st.isEmpty() && isAlive && st.peek() > 0){
                    if(st.peek() < Math.abs(n)){
                        st.pop();
                    }
                    else if(st.peek() == Math.abs(n)){
                        st.pop();
                        isAlive = false;
                    }
                    else{
                        isAlive = false;
                    }
                }
                if(isAlive){
                    st.push(n);
                }
            }
        }

        if(st.isEmpty()) return new int[]{};

        int[] ans = new int[st.size()];
        int i = st.size() - 1;

        while(i >= 0 && !st.isEmpty()){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}