class Solution {
public:
    /*vector<int> twoPointerMethod(vector<int>& arr, int k, int x){
        int l = 0;
        int h = arr.size()-1;

        while(h-l>=k){
            if(x - arr[l] > arr[h]-x){
                l++;
            }
            else{
                h--;
            }
        }
        //answer lies between l ans h
        vector<int>ans;
        for(int i=l; i<=h; i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }*/
    int lowerbound(vector<int>& arr, int x){
        int start = 0;
        int end = arr.size()-1;
        int ans = end; 
        while(start <= end){
            int mid = start+(end-start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    vector<int>binarySearchMethod(vector<int>& arr, int k, int x){
        int h = lowerbound(arr, x); //find the closest element to x
        int l = h-1;

        while(k--){
            if(l < 0){
                h++;
            }
            else if(h >= arr.size()){
                l--;
            }
            else if(x - arr[l] > arr[h]-x){
                h++;
            }
            else{
                l--;
            }
        }
        vector<int>ans;
        for(int i=l+1; i<h; i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //return twoPointerMethod(arr, k, x);
        return binarySearchMethod(arr, k, x);
    }
};