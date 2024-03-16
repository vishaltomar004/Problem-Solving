package HomeWork.Searching_3;

public class MinimumLimitofBallsinaBag {
    public int minimumSize(int[] nums, int maxOperations) {
         
        // Find max element  for max penalty
        int max = Integer.MIN_VALUE;
        for(int r:nums){
            max=Math.max(r,max);
        }
        // System.out.println(max);
//our search space will be b/n 1 and max
        int low=1;
        int high=max;

        //we will check for number b/n 1 and max assuming it to our penalty and check in array that it could satissy the condition within given macOperations
    int ans=high;
        while(low<high)
        {
            int mid= (low+high)/2;
            int ops=0;
            for(int i =0; i<nums.length; i++)
            {
                if(nums[i]>mid)
                {
                    if(nums[i] % mid ==0)
                    {
                        ops+=nums[i]/mid -1;
                    }
                    else 
                    {
                        ops+=nums[i]/mid;
                    }
                }
            }

            if(ops <= maxOperations)
            {
                ans=mid;
                high=mid;
            }
            else 
            {
     low=mid+1;
            }
        }
        return low;
    }

   
}
