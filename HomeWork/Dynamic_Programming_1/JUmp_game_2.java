package HomeWork.Dynamic_Programming_1;

public class JUmp_game_2 {
    class Solution {
        public int jump(int[] nums) {
            
            Integer dis [] = new Integer[nums.length];
            int n =nums.length;
            dis[n-1]=0;
            for(int i =n-2; i>=0; i--)
            {   
               int steps =nums[i];
               int min =Integer.MAX_VALUE;
                for(int j=1; j<=steps && i+j<n; j++)
                {
                    if(dis[i+j] !=null && dis[i+j] < min)
                    {
                   min=dis[i+j];
                    }
                }
               if(min!=Integer.MAX_VALUE)
               {
          dis[i]=min+1;
               }
          
               
        
        }
            return dis[0];
    }
    }
}
