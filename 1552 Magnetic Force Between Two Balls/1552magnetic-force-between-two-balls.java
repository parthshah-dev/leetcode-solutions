class Solution {
    static boolean isValid(int[] position, int m, int mid){
        int lastPos = position[0];
        int noOfBallsPlaced = 1;

        for(int i=1; i<position.length; i++){
            if(position[i] - lastPos >= mid){
                noOfBallsPlaced++;
                lastPos = position[i];

                if(noOfBallsPlaced >= m) return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = 1;

        while(left <= right){
            int mid = left+(right-left)/2;

            if(isValid(position, m, mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}