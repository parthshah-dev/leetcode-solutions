class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //Use map to store all index
        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(indexMap.containsKey(complement)){
                return new int[]{i, indexMap.get(complement)};
            }
            indexMap.put(arr[i], i);
        }
        return new int[]{};
    }
}