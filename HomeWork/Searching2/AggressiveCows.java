package HomeWork.Searching2;

import java.util.Arrays;
// starting from 1 we will check that if with minimum distance 1 can we place cows or not , if yes then we will check for 2 and so on till we got failed
//  Suppose for minimum distance of 5 we got failed then we will not check for number greater than 5 , rather we will move to left

public class AggressiveCows {
     public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
       int low=1;
       int high=stalls[n-1]-stalls[0];
       
       while(low<=high){
           int mid= (low+high)/2;
           if(canWePlace(stalls ,k,mid)){
               low=mid+1;
           }
           else {
               high =mid-1;
           }
       }
       return high;
    }
    
    static boolean canWePlace(int a[] , int cows ,int minD)
    {
     
     int countCow=1;
     int last=a[0];
      for(int i =1; i<a.length; i++){
          
          if(a[i] - last>=minD){
              last=a[i];
              countCow++;
          }
          
          if(countCow>=cows){
              return true;
          }
      }
      return false;
    }
}
