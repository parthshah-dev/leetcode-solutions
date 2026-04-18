class Solution {
    public static boolean isPossibleAns(int[] bloomDay, int m, int k, int mid){
        int count = 0; //number of flowers collected
        int boq = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                count++;
                if(count == k){
                    boq++;
                    count=0; //reset
                }
            }else{
                count=0;
            }
        }

        return boq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // find min and max
        for (int d : bloomDay) {
            left = Math.min(left, d);
            right = Math.max(right, d);
        }

        if(m*k > bloomDay.length) return ans;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossibleAns(bloomDay, m, k, mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}