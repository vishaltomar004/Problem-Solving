package HomeWork.Searchig_1;

public class Search_In_Roteted_Array {
    
    public int search(int[] nums, int target) {
        boolean found =false;
       int store=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]==target){
               found=true;
               store=i;
               break;
           }
       }
       if(found){

           return store;
       }
       else return -1;
       
   }
}



   
    
