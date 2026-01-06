class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i : nums){
            if(freq.containsKey(i)) return true;
            freq.put(i, 0);
        }
        return false;
    }
}