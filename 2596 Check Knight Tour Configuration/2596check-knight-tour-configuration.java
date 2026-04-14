class Solution {
    static boolean solve(int[][] grid, int r, int c, int n, int expValue){
        if(r < 0 || r >= n || c < 0 || c >= n){
            return false;
        }
        if(grid[r][c] != expValue){
            return false;
        }
        if(expValue == (n*n)-1){
            return true;
        }

        // try 8 possible moves
        boolean ans1 = solve(grid, r-2, c-1, n, expValue+1);
        boolean ans2 = solve(grid, r-2, c+1, n, expValue+1);

        boolean ans3 = solve(grid, r-1, c-2, n, expValue+1);
        boolean ans4 = solve(grid, r-1, c+2, n, expValue+1);

        boolean ans5 = solve(grid, r+1, c-2, n, expValue+1);
        boolean ans6 = solve(grid, r+1, c+2, n, expValue+1);

        boolean ans7 = solve(grid, r+2, c-1, n, expValue+1);
        boolean ans8 = solve(grid, r+2, c+1, n, expValue+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
    public boolean checkValidGrid(int[][] grid) {
        return solve(grid, 0, 0, grid.length, 0);
    }
}