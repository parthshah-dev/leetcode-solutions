class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans[] = new int[nums.length-k+1];
        int ansIdx = 0;

        //1. Process the first K elements
        for(int i=0; i<k; i++){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        ans[ansIdx++] = nums[deque.getFirst()];

        //2. Process the remaining elements
        for(int i=k; i<nums.length; i++){
            // Remove the elements that are not the part of current window
            while(!deque.isEmpty() && deque.getFirst() < i-k+1){
                deque.removeFirst();
            }

            // Remove elements that are smaller than current one
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);

            ans[ansIdx++] = nums[deque.getFirst()];
        }

        return ans;
    }
}