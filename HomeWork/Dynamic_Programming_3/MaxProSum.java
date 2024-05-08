package HomeWork.Dynamic_Programming_3;

public class MaxProSum {
    public int maxProduct(int[] nums) {
        int p=1;
        int s=1;
        int prefixmax=-20;
        int suffixmax=-20;
        int max;
      for(int i=0;i<nums.length;i++){
        p*=nums[i];
        prefixmax=Math.max(prefixmax,p);
        if(p==0){
          p=1;
        }
  
      }
      for(int j=nums.length-1;j>=0;j--){
        s*=nums[j];
        suffixmax=Math.max(suffixmax,s);
        if(s==0){
          s=1;
        }
        
        
      }
      max=(prefixmax>suffixmax)?prefixmax:suffixmax;
      
       
  
        return max;
          
      }
}
