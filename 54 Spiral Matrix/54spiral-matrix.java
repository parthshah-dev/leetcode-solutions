class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int startRow = 0, endRow = matrix.length-1, startCol = 0, endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            //top row
            for(int i=startCol; i<=endCol; i++){
                ans.add(matrix[startRow][i]);
            }

            //right col
            for(int i=startRow+1; i<=endRow; i++){
                ans.add(matrix[i][endCol]);
            }

            //bottom row
            for(int i=endCol-1; i>=startCol; i--){
                if(endRow == startRow) break;
                ans.add(matrix[endRow][i]);
            }

            //left row
            for(int i=endRow-1; i>=startRow+1; i--){
                if(endCol == startCol) break;
                ans.add(matrix[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return ans;
    }
}