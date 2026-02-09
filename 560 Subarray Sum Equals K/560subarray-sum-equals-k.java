class Solution {
    public int subarraySum(int[] nums, int k) {
       int[] prefixSum = new int[nums.length];
       HashMap<Integer, Integer> map = new HashMap<>();
       int count = 0;

       //Step 1: store prefix sum
       prefixSum[0] = nums[0];
       for(int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
       }

       for(int j=0; j<nums.length; j++){
        if(prefixSum[j] == k){
            count++;
        }
        if(map.containsKey(prefixSum[j] - k)){
            count += map.get(prefixSum[j] - k);
        }
        map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
       }

       return count;

    }
}