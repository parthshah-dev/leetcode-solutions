class Solution {
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void solve(String digits, List<String> ans, StringBuilder temp, int idx){
        
        if(temp.length() == digits.length()){
            ans.add(temp.toString());
            return;
        }

        if(idx == digits.length()) {
            return;
        }

        int index = digits.charAt(idx) - '0';
        String key = keypad[index];

        for(int i=0; i<key.length(); i++){
            temp.append(key.charAt(i));
            solve(digits, ans, temp, idx+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");

        solve(digits, ans, temp, 0);
        return ans;
    }
}