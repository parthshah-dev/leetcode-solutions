class Solution {
public:
    bool isValid(string s) {
        if(s[0] != 'a') return false;

        stack<char>st;
        for(char ch : s){
            st.push(ch);

            if(st.size() >= 3){
                char c = st.top(); st.pop();
                char b = st.top(); st.pop();
                char a = st.top(); st.pop();

                if(!(a=='a' && b=='b' && c=='c')){
                    st.push(a);
                    st.push(b);
                    st.push(c);
                }
            }
        }
        return st.empty();
    }
};