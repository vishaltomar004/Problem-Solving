package HomeWork.Miscellaneous_2;

import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessorEqualtoLimit {
     public int longestSubarray(int[] nums, int limit) {
       int ans=0;
      int j=0;
      int max=0;
      int min=10000001;
     // int sm=10000001;
      int cm=0;
      int cmi=0;
      PriorityQueue<Integer>ma=new PriorityQueue<>((a,b)->b-a);
       PriorityQueue<Integer>mi=new PriorityQueue<>((a,b)->a-b);
       for(int i=0;i<nums.length;i++){
        ma.offer(nums[i]);
        mi.offer(nums[i]);
       //System.out.println(ma.peek()+" "+mi.peek());
        while(Math.abs(ma.peek()-mi.peek())>limit){      
              ma.remove(nums[j]);
              mi.remove(nums[j]);
               j++;
        }
        ans=Math.max(ans,i-j+1);   
      }  
      return ans; 
    } 
}
