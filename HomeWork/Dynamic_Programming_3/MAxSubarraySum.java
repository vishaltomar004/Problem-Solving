package HomeWork.Dynamic_Programming_3;

public class MAxSubarraySum {
    public int maxSubArray(int[] nums) {
        int count=0;

        int c=0;
        int sum=nums[0];
        for(int i =0; i< nums.length; i++){
             c=c+nums[i];
            if(c>sum){
                sum=c;
            }
            if(c<0){
                c=0;
            }
        }
        return sum;
    }
}
