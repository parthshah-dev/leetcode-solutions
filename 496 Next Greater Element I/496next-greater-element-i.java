class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums2){
            while(!st.isEmpty() && n > st.peek()){
                map.put(st.pop(), n);
            }
            st.push(n);
        }

        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }

        int res[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}