package HomeWork.Searching2;

public class FindPeakElement {
    //Just iterate through the array and find a element satisfying arr[i-1]<=arr[i] && arr[i+1]<=arr[i] and return
    
    public int findPeakElement(int[] arr) {
        int n =arr.length;
          if(n==1){
           return 0;
       }
       
      for(int i=1; i<n-1; i++){
          if(arr[i-1]<=arr[i] && arr[i+1]<=arr[i]){
              return i;
          }
      }
      
      if(arr[n-2]<=arr[n-1]){
          return n-1;
      }
      return 0;
    }
}
