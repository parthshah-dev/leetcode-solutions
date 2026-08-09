class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        int i=0;
        while(i < 2*n){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                ans[st.pop()] = nums[i % n];
            }
            if(i < n){
                st.push(i);
            }
            i++;
        }
        return ans;
    }
}