package HomeWork.Dynamic_Programming_2;

public class NumberofDiceRollsWithTargetSum {
    class Solution {
        int mod = (int)Math.pow(10,9) + 7;
        // int ans = 0 ;
        public int numRollsToTarget(int n, int k, int target) {
                 int dp[][] = new int[n+1][target+1];
              dp[0][0]=1;
              for(int i = 1 ; i < n+1 ; i++){
                for(int j = 1 ; j < target+1 ; j++){
                    int ans = 0 ;
                    for(int l = 1 ; l <= k ; l++){
                        int temp = j - l ;
                        if(temp >= 0){
                            int x  = dp[i-1][temp] % mod ;
                            ans= ((ans%mod) + (x % mod)) % mod;
                        }
                    }
                    dp[i][j] = ans ;
                }
              }
              return dp[n][target] % mod;
    
            //  return help(n,k,target,dp);  
            // return ans ;
        }
    
    
    //   int help(int n , int k , int target , int dp[][])
    //   {
    //     //  System.out.println(n);
        
    
    //     if(target==0){
    //         if(n!=0) return 0 ;
             
    //         return  1;
    //     }
    
    //     if(n<=0 || target < 0) return 0 ;
    
    //      if(dp[n][target]!=0) return dp[n][target] ;
    
    //     int ans=0;
    //     for(int i =1; i<=k; i++)
    //     {
    //     //   System.out.println("Target = "+target + " ans = "+ ans);
    //         ans=ans+ help(n-1 , k , target-i,dp);
    //     }
    
    //     return dp[n][target]=ans;
    //   }
    
    int help(int n , int k , int target , int dp[][])
      {
        //  System.out.println(n);
        
    
        if(target==0){
            if(n!=0) return 0 ;
             
            return  1;
        }
    
        if(n<=0 || target < 0) return 0 ;
    
         if(dp[n][target]!=0) return dp[n][target] ;
         
        int ans=0;
        for(int i =1; i<=k; i++)
        {
        //   System.out.println("Target = "+target + " ans = "+ ans);
    
            ans=ans+ help(n-1 , k , target-i,dp);
        }
    
        return dp[n][target]=ans;
      }
    }
}
