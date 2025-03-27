class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int start = 0, end = arr.size()-1, mid, ans = arr.size();
        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid]-mid-1>=k){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans+k;

        /*vector<int>ans; //keep track of missing numbers
        int currE = 1;
        int i=0; 
        while(ans.size() < k){ //TC - O(log n)
            if(i < arr.size() && arr[i] == currE){
                i++;
            }
            else{
                ans.push_back(currE);
            }
            currE++;
        }
        return ans[k-1];*/
    }
};