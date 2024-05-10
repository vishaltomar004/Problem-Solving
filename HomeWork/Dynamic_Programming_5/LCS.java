package HomeWork.Dynamic_Programming_5;

import java.util.Arrays;

public class LCS {
    class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int n1=text1.length();
        // int n2=text2.length();
        // int dp[][] = new int[n1+1][n2+1];
        // for(int i =0; i<n1; i++)
        // {
        //     dp[i][0]=0;
        // }

        // for(int i =0; i<n2; i++)
        // {
        //     dp[0][i]=0;
        // }

        // for(int i =1; i<n1; i++)
        // {
        //     for(int j=1; j<n2; j++)
        //     {
        //         if(text1.charAt(i-1)==text2.charAt(j-1))
        //         {
        //             dp[i][j]=dp[i-1][j-1]+1;
        //         }
        //         else 
        //         {
        //             dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
        //         }
        //     }
        // }

        // return dp[n1][n2];

        int n =text1.length();
        int m = text2.length();

        int dp[][]= new int[n][m];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
         return f(n-1, m-1 , text1, text2 , dp);

    }

    int f(int i , int j, String s , String t , int dp[][])
    {
        if(i< 0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j))return dp[i][j] = 1 +f(i-1,j-1 , s ,t,dp);

         return  dp[i][j] = Math.max(f(i-1 , j ,s ,t,dp) , f(i, j-1,s,t,dp));
    }
}
}
