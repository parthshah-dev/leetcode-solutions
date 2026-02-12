class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int runningSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for(int j=0; j<nums.length; j++){
            runningSum += nums[j];
            int remainder = runningSum % k;

            if(remainder < 0){
                remainder += k;
            }
            if(map.containsKey(remainder)){
                result += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return result;
    }
}