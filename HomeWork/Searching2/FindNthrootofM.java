package HomeWork.Searching2;

public class FindNthrootofM {
    public int NthRoot(int n, int m)
    {
        // code here
        int start =0;
        int end = m;
        int mid=-1;
        // using binary search
        
        while(start<=end)
        {
            // find mid 
             mid = start  +(end-start)/2;
             // Find the mid to the power n 
             // if ch equals m return it, if ch greater than m , focous to left .else to right 
            double ch = Math.pow(mid,n);
            if((int)ch == m){
                return mid;
            }
            else if((int)ch > m){
                end=mid-1;
            }
            else 
            {
                start =mid+1;
            }
        }
        
        return -1;
    }
}
