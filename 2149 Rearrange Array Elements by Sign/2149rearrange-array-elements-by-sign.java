class Solution {
    public int[] rearrangeArray(int[] nums) {
        /*
        int n = (nums.length) / 2;

        int[] pos = new int[n];
        int[] neg = new int[n];

        int i = 0; //pointer to pointer positive array
        int j = 0; //pointer to pointer negative array
        for(int k : nums){
            if(k < 0){
                neg[j] = k;
                j++;
            }else{
                pos[i] = k;
                i++;
            }
        }

        i = 0;
        for(int k=0; k<nums.length; k+=2){
            nums[k] = pos[i];
            i++;
        }

        j = 0;
        for(int k=1; k<nums.length; k+=2){
            nums[k] = neg[j];
            j++;
        }

        return nums;
        */

        //Optimized - only one loop
        int negIdx = 1;
        int posIdx = 0;
        int[] ans = new int[nums.length];

        for(int k : nums){
            if(k < 0){
                ans[negIdx] = k;
                negIdx += 2;
            }else{
                ans[posIdx] = k;
                posIdx += 2;
            }
        }
        return ans;
    }
}