package HomeWork.Dynamic_Programming_1;

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
          int n=nums.length;
          int dp[]= new int[n];
    
          if(n>2)
          {
            dp[0]=nums[0];
            dp[1]=nums[1];
          }
    
    
          for(int i =2; i<n; i++)
          {
                   dp[i] = dp[i-2]+ nums[i];
          }
    
          return dp[]
        }
    } 
}
