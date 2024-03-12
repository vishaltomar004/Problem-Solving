package HomeWork.Searching2;

public class Single_Element_In_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        
        int left=0;
        int right=nums.length-1;

//Using Binary Search
// the elements are in pair so every second element of the pair should be on odd place
// we will check whether mid is even or odd
// if mid is odd , will make it even
// now if the next element of mid is also equals to mid  it mean element is present in left position 
// will make right=mid
// other wise element is present in right
//will make left to mid+2, 
// at the end  both left and right will coinside at samepoint 
        while(left<right)
        {
           int mid= left +(right-left)/2;

           if(mid %2!=0){
            mid--;
           }
           if(nums[mid]!=nums[mid+1]){
            right=mid;
           }
           else {
            left=mid+2;
           }c
    }
    return nums[left];
}

}