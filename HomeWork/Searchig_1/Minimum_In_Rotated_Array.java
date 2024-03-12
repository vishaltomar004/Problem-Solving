package HomeWork.Searchig_1;

/**
 * Minimum_In_sorted_array
 */
public class Minimum_In_sorted_array {

    public int findMin(int[] nums) {
        
        int min=nums[0];
        int low =0;
        int high =nums.length-1;
 
 //using binary search 
 
        while(low<=high){
          int mid= low + (high - low)/2;
 // check if the right part of the array is sorted
 // if the array is sorted then find minimum of right part  and now our operating will be left part, as we have found minimun from the right part
         if(nums[mid]<=nums[high] )
         {
             if(min>nums[mid])
             {
                 min=nums[mid];   
             }
              high=mid-1;
         else
         //// if right is not sorted then left will definitely sorted
     //    find minimum of left part  and now our operating will be right  part, as we have found minimun from the right part
             if(min>nums[low])
             {    
                 min=nums[low];
 
             }
             
             
              low=mid+1;
                System.out.println("INside if low  = "+ low);
         }
         }
         return min;
     }
}