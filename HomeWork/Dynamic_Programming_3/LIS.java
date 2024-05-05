package HomeWork.Dynamic_Programming_3;

import java.util.ArrayList;
import java.util.Collections;

public class LIS {
    class Solution {
    public int lengthOfLIS(int[] nums) {
// ---------------------------------------------------------TABULAR SOLUTION---------------------------------------------------------
        //  int ans=0;
         
        //     int n =nums.length;
        //     if(n==1) return 1;
        //     int dp[]=new int[n];
        //     dp[0]=1;
        //     for(int i =1; i<n; i++)
        //     {
        //         int max =0;
        //         for(int j=0; j<i ; j++)
        //         {
        //             if(nums[i]>nums[j])
        //             {
        //                 max=Math.max(dp[j] ,max);
        //         }
        //         dp[i] = max+1;
        //         ans=Math.max(ans , dp[i]);

        //     }
        //     }
        //     for(int e:dp) System.out.print(e+" ");
        //     return ans;

    //   int n =nums.length;
    //    ArrayList<Integer> al = new ArrayList<>();
    //     return help(nums ,al);

// ---------------------------------------------------------BS---------------------------------------------------------
     ArrayList<Integer> al = new ArrayList<>();
       
        int len = 1;
 int n =nums.length;
     al.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > al.get(al.size() - 1)) {
               

                al.add(nums[i]);
                len++;
            } else {
               
                int ind = Collections.binarySearch(al, nums[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                al.set(ind, nums[i]);
            }
        }

        return len;
    }
 

//   ---------------------------------------------------------RECURSION SOLUTION GIVING TLE---------------------------------------------------------
    // int help(int nums[] , int curr , int prev)
    // {
    //     if(curr==nums.length)
    //     {
    //         return 0;
    //     }

    //      int len = help(nums , curr+1 , prev);
    //      if(prev==-1 || nums[curr] > nums[prev])
    //      {
    //        len = Math.max( len , 1 + help( nums , curr+1 , curr));
    //      }
    //      return len;
    // }


//--------------------------------------------------------- MEMOIZATION---------------------------------------------------------
    // int help(int nums[] , int curr , int prev , int dp[][])
    // {
    //     if(curr==nums.length)
    //     {
    //         return 0;
    //     }
        
    //     if(dp[curr][prev+1] !=-1)
    //     {
    //         return dp[curr][prev+1];
    //     }
    //      int len = help(nums , curr+1 , prev ,dp);
    //      if(prev==-1 || nums[curr] > nums[prev])
    //      {
    //        len = Math.max( len , 1 + help( nums , curr+1 , curr ,dp));
    //      }
    //      dp[curr][prev+1] = len;
    //      return dp[curr][prev+1] ;
    // }

          
    
}
}
