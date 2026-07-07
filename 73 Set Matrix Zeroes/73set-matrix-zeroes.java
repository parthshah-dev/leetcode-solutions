class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowAffected = false;
        boolean firstColAffected = false;

        for(int j=0; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                firstRowAffected = true;
                break;
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColAffected = true;
                break;
            }
        }

        //Mark for filling
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //fill matrix
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowAffected){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstColAffected){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}