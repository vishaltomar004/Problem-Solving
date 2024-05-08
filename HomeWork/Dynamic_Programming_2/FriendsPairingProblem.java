package HomeWork.Dynamic_Programming_2;

public class FriendsPairingProblem {
    long mod=(long)1e9+7;// 1e9+7=1000000000+7=1000000007
    if(n==1)
    return 1;
  long[] dp=new long[n+1];
  dp[1]=1;
  dp[2]=2;
  for(int i=3;i<=n;i++){
  dp[i]=dp[i-1]+dp[i-2]*(i-1);
  dp[i]=dp[i]%mod;
      
  }
  return dp[n];
}
