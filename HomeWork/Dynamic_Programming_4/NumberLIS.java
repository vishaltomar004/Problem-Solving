package HomeWork.Dynamic_Programming_4;

public class NumberLIS {
    int n = nums.length;
   
    int[][] dp = new int[n][2];
    dp[0][0] = 1; 
    dp[0][1] = 1; /
    int max = 1;
    for(int i = 1; i < n; i++) {
        dp[i][0] = dp[i][1] = 1;
        for(int j = 0; j < i; j++) {
            if(nums[j] < nums[i]){
          
                if(dp[j][0] + 1 > dp[i][0]) { dp[i][0] = dp[j][0] + 1; dp[i][1] = dp[j][1]; }
      
                else if(dp[j][0] + 1 == dp[i][0]) { dp[i][1] = dp[i][1] + dp[j][1]; }
            }
        }
        max = Math.max(max, dp[i][0]);
    }
    int count = 0;
    for(int[] x : dp) if(max == x[0]) count+=x[1];
    return count;
}
