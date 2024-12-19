class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        int start = 0, end = rows*cols-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            int row_index = mid / cols;
            int cols_index = mid % cols;

            if(matrix[row_index][cols_index] == target)  
                return 1;
            else if(matrix[row_index][cols_index] > target)
                end = mid - 1;
            else{
                start = mid + 1;
            }
        }
        return 0;
    }
};