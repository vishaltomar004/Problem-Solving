package HomeWork.Searching_3;
// You have given an array A having N elements and an integer S. You have to find a maximum number X such that the sum of all its subarrays of size X is less than or equal to S.
// Example Input:  
//     A = [1, 3, 4, 2]  
//     S = 7  
// Example Output:  
//     2  
// Explanation:  
//     All subarrays of size 2 have the sum less than 7.  
//     Subarays are :  
//     1. [1, 3]  
//     2. [3, 4]  
//     3. [4, 2]  



public class SubArrayWithSumS {
    public static void main(String[] args) {
            
        int a[] = {1,3,4,2};
        int n =a.length;
        int s=7;

        // we will start from size of array -1 
        // maximum length of sub array can be length -1 , with 2 subaarays
        //minimum length of subarray can be 1

        int low=1;
        int high=n-1; // max length can be
int ans=0;
        while(low<high){ 

            int mid=low + (high-low)/2;

            // now we will check for all the subaarays of length mid
            // if any array of length mid dissatisfies i.e sum > s it means subarray greater than mid will definitely dissatisfy
            //ans move our high to mid-1

            if(!satisfying(a , mid ,s))
            {
                high = mid-1;
            }
            else {
                ans=mid;
                low=mid+1;
            }
        }

        System.out.println(ans);
                 
          
         
       
       
    }
static boolean satisfying(int a[] , int size , int s){

    int i =0;
    int j=size;
    int sum=0;
 for(int q=0; q<size; q++){
    sum+=a[i];
 }
// calculating sum of subarray of size size
    while(j<a.length){
       // if we encounter any condition it which condition in not satisfying return false;
        if(sum>s)
        {
            return false;
        }
        else 
        {
            
            sum=sum-a[i];
            i++;
            sum=sum+a[j];
            j++;
        }
    }
    return true;
}
     
}
