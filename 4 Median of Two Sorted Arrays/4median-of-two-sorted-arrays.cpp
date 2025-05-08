class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int>nums3;
        int i = 0, j = 0;
        int n = nums1.size();
        int m = nums2.size();
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                nums3.push_back(nums1[i]);
                i++;
            }
            else{
                nums3.push_back(nums2[j]);
                j++;
            }
        }
        //if any element remaining in nums1
        while(i < n){
            nums3.push_back(nums1[i]);
            i++;
        }
        //if any element remaining in nums2
        while(j < m){
            nums3.push_back(nums2[j]);
            j++;
        }

        //median calculation
        double median;
        //if array has odd number of elements
        if(nums3.size() % 2 != 0){
            median = nums3[nums3.size() / 2];
        }
        else{
            median = (nums3[nums3.size() / 2 - 1] + nums3[nums3.size() / 2]) / 2.0;
        }
        return median;
    }
};