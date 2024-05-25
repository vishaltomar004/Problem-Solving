package HomeWork.Dynamic_Programming_7;

/**
 * Edit_distances
 */
public class Edit_distances {

    class Solution {
        public int minDistance(String word1, String word2) {
            int n =word1.length();
            int m =word2.length();
            // int dp[][] = new int[n+1][m+1];
            // for(int [] e: dp)
            // {
            //     Arrays.fill(e,-1);
            // }
            //  for(int i = 0;i<=n;i++){
            //     for(int j = 0;j<=m;j++)
            //         if(i==0||j==0)
            //             dp[i][j] = i==0 ? j :i;
            // }
            //  int ans = min(word1,word2, n,m ,dp);
            // ans = dp[n][m];
            //  return ans;
    
    
              int[] prev = new int[m + 1];
            int[] cur = new int[m + 1];
            if(m==0 || n==0) return 0;
           return min(word1, word2, cur, prev , n ,m);
    
        }
    
    // _______________________________Recursion________________________________________
    //     int min(String s1, String s2 ,int i ,int j)
    //     {
    //         if(i<0 && j<0)
    //         {
    //             return 0;
    //         }
             
    //          if(i<0) return j+1;
    //          if(j<0) return i+1;
    //         if(s1.charAt(i) == s2.charAt(j))
    //         {
    //             return min(s1,s2, i-1, j-1);
    //         }
    //         else 
    //         {
    
    //             int insert = min(s1 , s2, i-1, j-1);
                
    //             int add = min(s1 , s2, i, j-1);
                
    //             int remove = min(s1 , s2, i-1, j);
    //             return Math.min( insert , Math.min(add, remove)) +1;
    //         }
        
    //         }
    
    
    // _______________________________________MEMO______________________________________
    //    int min(String s1, String s2 ,int i ,int j , int dp[][])
    //     {
    //         if(i==0 || j==0)
    //         {
    //             return i==0? j:i;
    //         }
              
    //           if(dp[i][j]!=-1) return dp[i][j];
         
    //            int ans=0;
    //         if(s1.charAt(i-1) == s2.charAt(j-1))
    //         {
    //             ans=  min(s1,s2, i-1, j-1,dp);
    //         }
    //         else 
    //         {
    
    //             int insert = min(s1 , s2, i-1, j-1,dp);
                
    //             int add = min(s1 , s2, i, j-1,dp);
                
    //             int remove = min(s1 , s2, i-1, j,dp);
    //                 ans= Math.min( insert , Math.min(add, remove)) +1;
    //         }
    //         dp[i][j]=ans;
    //         return ans;
    //         }
    
    
    int min(String s1, String s2 , int cur[] , int prev[],int n , int m)
    {
          for (int j = 0; j <= m; j++) {
                prev[j] = j;
            }
    
            for (int i = 1; i <= n; i++) {
                cur[0] = i;
                for (int j = 1; j <= m; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                      
                        cur[j] = prev[j - 1];
                    } else {
                    
                        cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                    }
                }
    
                prev = cur.clone();
            }
    
            return cur[m];
    }
    
    }
}