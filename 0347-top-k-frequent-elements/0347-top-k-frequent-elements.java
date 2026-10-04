class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for(int n : map.keySet()){
            pq.offer(n);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int idx = 0;
        int[] ans = new int[k];
        while(!pq.isEmpty()){
            ans[idx++] = pq.poll();
        } 
        
        return ans;
    }
}