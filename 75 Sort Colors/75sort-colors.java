class Solution {
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while(mid <= end){
            if(arr[mid] == 0){
                swap(arr, mid, start);
                start++;
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, end);
                end--;
            }
            else{
                mid++;
            }
        }
    }
}