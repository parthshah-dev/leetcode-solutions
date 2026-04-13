class Solution {
    private static boolean isSafe(char[][] board, int row, int col, char num) {
        //check column
        for(int i=0; i< board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //check row
        for(int i=0; i<board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //check 3X3 matrix
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i=startRow; i<=startRow+2; i++){
            for(int j=startCol; j<=startCol+2; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }
    static boolean solve(char[][] board, int row, int col){
        if(row == board.length){
            return true;
        }

        if(col == board.length){
            return solve(board, row+1, 0);
        }

        //for each cell placing try 1 to 9
        if(board[row][col] != '.'){
            return solve(board, row, col+1);
        }else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isSafe(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (solve(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.'; // backtrack
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}