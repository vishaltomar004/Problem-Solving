package HomeWork.Dynamic_Programming_3;

public class DiceCombination {
    public static int countWaysToSum(int n) {
      
        int[] dp = new int[n + 1];
        
       
        dp[0] = 1;
        
       
        for (int i = 1; i <= 6; i++) {
         
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }
        }
        
      
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Number of ways to construct sum " + n + " : " + countWaysToSum(n));
    }
}
