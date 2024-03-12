package HomeWork.Searchig_1;

public class Rotation {

    // iterate in array 
    // find a place in array where first element is bigger than next ,
    // return index of bigger
    int findKRotation(int arr[], int n) {
        // code here
        for(int   i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }
}
