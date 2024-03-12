package HomeWork.Searchig_1;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] arr, int k) 
    {

        //Approach 
        // use binary sort
        // check id mid element is equals target(k) return true;
        // check whether element at mid , low or high all are equal if yess then decrease low , high till this condition dissatisfies
        // Now check for sorted array
        // if left is sorted side , check for element existance is no existence move low pointer to mid+1
        // same for right side 
        int n = arr.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if mid points the target
            if (arr[mid] == k) return true;

            //Edge case:
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (arr[mid] <= k && k <= arr[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
        }
}

