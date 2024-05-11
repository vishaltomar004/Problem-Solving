package HomeWork.Dynamic_Programming_4;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
       
       int dr=dp.length-1;
       int dc=dp[0].length-1;
    
      for(int r=dr;r>=0;r--){
        for(int c=dc;c>=0;c--){
            int rp1=r+1;  
            int cp1=c+1;
            
            if(obstacleGrid[r][c]==1){ 
                dp[r][c]=0;
            }else if(r==dr && c==dc){
                 dp[r][c]=1;  
            }else if(r==dr){
                 dp[r][c]=dp[r][cp1];  
            }else if(c==dc){
                  dp[r][c]=dp[rp1][c];
            }else{
                dp[r][c]=dp[rp1][c] + dp[r][cp1];
            }
        }  
      }
    return dp[0][0];
      }
}
