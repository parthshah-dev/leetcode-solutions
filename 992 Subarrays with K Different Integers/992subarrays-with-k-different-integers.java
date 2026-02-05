class Solution {
    public int atMostK(int[] nums, int k){
        int i = 0;
        int j=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalCount = 0;

        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            totalCount += j-i+1;
            j++;
        }
        return totalCount;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1); 
    }
}