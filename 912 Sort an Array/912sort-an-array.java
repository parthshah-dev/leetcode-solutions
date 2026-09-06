class Solution {
    public static void merge(int[]nums, int start, int end, int mid){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k=0;

        while(i <= mid && j <= end){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i];
                i++;
            }else{
                temp[k++] = nums[j];
                j++;
            }
        }
        while(i <= mid){
            temp[k++] = nums[i];
            i++;
        }
        while(j <= end){
            temp[k++] = nums[j];
            j++;
        }

        //merge into org array
        for(int x=0; x<temp.length; x++){
            nums[x+start] = temp[x];
        }
    }
    public static void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = (end+start)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);

        merge(nums, start, end, mid);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);

        return nums;
        
    }
}