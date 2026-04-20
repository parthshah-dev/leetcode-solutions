class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == key){
                freq.put(nums[i+1], freq.getOrDefault(nums[i+1], 0) + 1);
            }
        }

        int ans = 0;
        int maxFreq = Integer.MIN_VALUE;
        
        for (int k : freq.keySet()) {
            if (freq.get(k) > maxFreq) {
                maxFreq = freq.get(k);
                ans = k; 
            }
        }
        return ans;
    }
}