package HomeWork.Dynamic_Programming_1;

public class AdjascentNotAllowed {
    static int maxSum(int N, int mat[][])
    {
        // code here
             int dp [] = new int[N+1];
       dp[0] = 0;
       
       dp[1] = Math.max(mat[0][0], mat[1][0]);
       
       dp[2] = Math.max(dp[1], Math.max(mat[0][1], mat[1][1])); 
       
       for(int i=3; i<=N; i++) {
           
          
           dp[i] = Math.max(dp[i-2] + Math.max(mat[0][i-1], mat[1][i-1]), dp[i-1]);
           
       }
       
      return dp[N]; 
        
    }
}
