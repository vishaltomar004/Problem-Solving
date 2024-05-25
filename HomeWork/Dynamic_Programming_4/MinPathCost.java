package HomeWork.Dynamic_Programming_4;

public class MinPathCost {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        
     
        for(int c = 0; c<col; c++){
            dp[0][c] = grid[0][c];
        }
        
      
        for(int r = 1; r<row; r++){
            for(int c = 0; c<col; c++){
                dp[r][c] = getMin(grid, moveCost, r, c, dp);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int k : dp[row-1])
            result = Math.min(result, k);
        
        return result;
        
    }
    

    private int getMin(int[][] grid, int[][] moveCost, int row, int col, int[][] dp){
        int min = Integer.MAX_VALUE, previousRow = row-1;
      
        for(int c = 0; c<grid[0].length; c++){
            min = Math.min(min, dp[previousRow][c] + grid[row][col] + moveCost[grid[previousRow][c]][col]);
        }
        return min;
    }
}
