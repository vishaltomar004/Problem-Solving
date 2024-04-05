package HomeWork.Searching_5;

import java.util.ArrayList;

public class KthElementOFTwoSortedArrays {
      public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {

        if(n>m){

            return kthElement(arr2, arr1, m, n, k);

        }

        int left = k;

        int low = Math.max(0, k-m);

        int high = Math.min(k, n);

        int nt = n+m;

        while(low<=high){

            int mid1 = (low+high)/2;

            int mid2 = left-mid1;

            int l1 = (mid1 > 0) ? arr1.get(mid1-1) : Integer.MIN_VALUE;

            int l2 = (mid2 > 0) ? arr2.get(mid2-1) : Integer.MIN_VALUE;

            int r1 = (mid1 < n) ? arr1.get(mid1) : Integer.MAX_VALUE;

            int r2 = (mid2 < m) ? arr2.get(mid2) : Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){

                return Math.max(l1, l2);

            }

            else if(l1>r2){

                high = mid1-1;

            }

            else{

                low=mid1+1;

            }

        }

        return 0;

    }
}
