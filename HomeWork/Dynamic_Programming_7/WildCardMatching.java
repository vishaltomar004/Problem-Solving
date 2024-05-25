package HomeWork.Dynamic_Programming_7;

public class WildCardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int i = s.length();
            int j = p.length();
            if(j == 0 && i!= 0)
                return false;
            
            boolean[][] dp = new boolean[i][j];
            return match(s,p,i-1,j-1,dp);
        }
        
        public boolean match(String s , String p , int i , int j , boolean[][] dp)
        {
            if(i < 0 && j < 0)
                return true;
            
            if(i < 0){
                for(int k = 0 ; k <= j ; k++)
                    if(p.charAt(k) != '*')
                        return false;
                
                return true;
            }
            
            if(j < 0)
            {
                return false;
            }
            
            if(dp[i][j])
                return dp[i][j];
            
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i][j] = match(s,p,i-1,j-1,dp);
            else if(p.charAt(j) == '*') dp[i][j] = match(s,p,i-1,j,dp) | match(s,p,i,j-1,dp);
            
            return dp[i][j];
            
        }
    }
}
