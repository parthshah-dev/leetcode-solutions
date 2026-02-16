class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];
        int prefix[][] = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                prefix[i][j] = mat[i][j];
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=1; j<cols; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        for(int j=0; j<cols; j++){
            for(int i=1; i<rows; i++){
                prefix[i][j] += prefix[i-1][j];
            }
        }

        //calculate ans for each i and j
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int startRow = Math.max(0, i-k);
                int endRow = Math.min(rows-1, i+k);
                int startCol = Math.max(0, j-k);
                int endCol = Math.min(cols-1, j+k);


                int sum = prefix[endRow][endCol];
                if(startRow-1 >= 0) sum -= prefix[startRow-1][endCol];
                if(startCol-1 >= 0) sum -= prefix[endRow][startCol-1];
                if(startRow-1 >= 0 && startCol-1 >= 0) sum += prefix[startRow-1][startCol-1];

                ans[i][j] = sum;
            }
        }

        return ans;
    }
}