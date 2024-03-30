package HomeWork.Searching_5;

public class KthElement {
    public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
         int l = mat[0][0], r = mat[n - 1][n - 1];
 
    while (l <= r) {
      int mid = l + (r - l) / 2;
      int greaterThanOrEqualMid = getElementsGreaterThanOrEqual(mid, n, mat);
 
      if (greaterThanOrEqualMid >= k)
        r = mid - 1;
      else
        l = mid + 1;
    }
    return l;
         
    }
    
    
    
     static int getElementsGreaterThanOrEqual(int num, int n, int mat[][]) 
  {
    int ans = 0;
 
    for (int i = 0; i < n; i++)
    {
      if (mat[i][0] > num) {
        return ans;
      }
      if (mat[i][n - 1] <= num) {
        ans += n;
        continue;
      }
      int greaterThan = 0;
      for (int jump = n / 2; jump >= 1; jump /= 2) {
        while (greaterThan + jump < n &&
               mat[i][greaterThan + jump] <= num) {
          greaterThan += jump;
        }
      }
 
      ans += greaterThan + 1;
    }
    return ans;
  }
}
