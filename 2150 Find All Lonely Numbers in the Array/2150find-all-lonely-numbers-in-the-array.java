class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(freq.get(x) == 1 && !freq.containsKey(x-1) && !freq.containsKey(x+1)){
                ans.add(x);
            }
        }
        return ans;
    }
}