package HomeWork.Dynamic_Programming_1;

import java.util.Arrays;

public class Perfect_Squares {
    class Solution {
   
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp ,-1);
        dp[0]=0;
        return solve(n , dp);
    }


    int solve(int n , int dp[])
    {           

        if(n<=0) return 0; 
         int ans=Integer.MAX_VALUE;
        if(dp[n] !=-1)
        {
            return dp[n];
        }

        for(int i =1 ; i*i <=n ; i++)
        {
            int num = i*i;
            int count = 1 + solve(n-num , dp);
            ans = Math.min(count , ans);
        }
        return dp[n]=ans;
    }
}
}
