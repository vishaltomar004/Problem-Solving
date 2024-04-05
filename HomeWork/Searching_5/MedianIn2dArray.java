package HomeWork.Searching_5;

public class MedianIn2dArray {
    
}


public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        
        int n = A.size();
        int m = A.get(0).size();
        
        int start = 0;
        int end = 1000000002;
        int ans = -1;
        while(start <= end) {
            
            int mid = start + (end - start) / 2;
            
            int count = getLessThan(mid, A);
            //System.out.println(mid + " " + count);
            
            if(count <= (n * m) / 2) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    public int getLessThan(int mid, ArrayList<ArrayList<Integer>> A) {
        
        int n = A.size();
        int m = A.get(0).size();
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            
            if(A.get(i).get(m - 1) < mid) {
                count += m;
            } else if(A.get(i).get(0) < mid) {
                int start = 0;
                int end = m - 1;
                int ans = 0;
                
                while(start <= end) {
                    int mi = start + (end - start) / 2;
                    if(A.get(i).get(mi) < mid) {
                        ans = mi;
                        start = mi + 1;
                    } else {
                        end = mi - 1;
                    }
                }
                
                count += ans + 1;
            }
        }
        
        return count;
    }
}