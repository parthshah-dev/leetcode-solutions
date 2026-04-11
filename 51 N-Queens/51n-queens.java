class Solution {
    static void storeAns(char[][] board, List<List<String>> ans){
        List<String> temp = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            temp.add(new String(board[i]));
        }
        ans.add(temp);
    }
    static boolean isValidPos(char[][] board, int row, int col){
        //check vertically col
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //check left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //check right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    static void nQueens(char[][] board, int row, List<List<String>> ans){
        if(row == board.length){
            storeAns(board, ans);
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isValidPos(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1, ans);
                board[row][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(board, 0, ans);
        return ans;
    }
}