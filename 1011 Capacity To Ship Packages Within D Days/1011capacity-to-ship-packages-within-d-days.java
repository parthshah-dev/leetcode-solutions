class Solution {
    static boolean isPossibleAns(int[] weights, int days, int mid){
        int d = 1;
        int currW = 0;

        for(int i=0; i<weights.length; i++){
            if(currW + weights[i] > mid){
                currW = weights[i];
                d++;

                if(d > days) return false; //early exit
            }else{
                currW += weights[i];
            }
        }
        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int ans = 0;

        for(int n : weights){
            left = Math.max(left, n);
            right += n;
        }

        while(left <= right){
            int mid = left+(right-left)/2;

            if(isPossibleAns(weights, days, mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}