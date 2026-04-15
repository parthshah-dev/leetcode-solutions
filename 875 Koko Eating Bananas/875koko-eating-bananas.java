class Solution {
    static boolean isPossibleAns(int[] piles, int h, int mid){
        long hrs = 0;

        for(int i=0; i<piles.length; i++){
            hrs += piles[i]/mid;
            if(piles[i] % mid != 0){
                hrs++;
            }

            if(hrs > h) return false;
        }

        return hrs <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        int ans = 0;

        for(int n : piles){
            right = Math.max(right, n);
        }

        while(left <= right){
            int mid = left+(right-left)/2;

            if(isPossibleAns(piles, h, mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}