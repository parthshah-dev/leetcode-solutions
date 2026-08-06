class Solution {
    public static boolean isValid(int[] dist, double hour, int mid){
        double h = 0;

        for(int i=0; i<dist.length; i++){
            if(i == dist.length-1){
                h += (double) dist[i] / mid;
            }else{
                h += Math.ceil((double) dist[i] / mid);
            }
        }
        return h <= hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int ans = -1;
        int left = 1;
        int right = 10_000_000;

        while(left <= right){
            int mid = left+(right - left)/2;

            if(isValid(dist, hour, mid)){
                ans = mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}