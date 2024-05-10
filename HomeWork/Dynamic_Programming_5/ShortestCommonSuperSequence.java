package HomeWork.Dynamic_Programming_5;

public class ShortestCommonSuperSequence {
    class Solution {
        public String shortestCommonSupersequence(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m+1][n+1];
            
            
            
            for(int i = 0; i < m; i++)
                dp[i][0] = 0;
            
            for(int i = 0; i < n; i++)
                dp[0][i] = 0;
            
    
            for(int i = 1; i <=m; i++){
                for(int j = 1; j <=n; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
                }
            }
            
           
            
            int i=m,j=n;
            String ans="";
            while(i>0 && j>0)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    ans+=word1.charAt(i-1);
                    i--;
                    j--;
                }
                
                else if(dp[i-1][j]>dp[i][j-1])
                {
                    ans+=word1.charAt(i-1);
                    i--;
                }
                else{
                    ans+=word2.charAt(j-1);
                    j--;
                }
            }
            
            while(i>0)
            {
                ans+=word1.charAt(i-1);
                i--;
            }
            while(j>0)
            {
                ans+=word2.charAt(j-1);
                j--;
            }
            
        
            
        StringBuilder sb=new StringBuilder(ans);  
        sb.reverse();  
        return sb.toString();  
        }
    }
}
