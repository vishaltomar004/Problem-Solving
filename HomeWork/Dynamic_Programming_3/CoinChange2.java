package HomeWork.Dynamic_Programming_3;

import java.util.Scanner;

public class CoinChange2 {
     static final int MOD = 1000000007;

    public static int countWays(int n, int x, int[] coins) {
        int[] dp = new int[x + 1];
        dp[0] = 1; // There is one way to make sum 0, by choosing no coin.

        for (int coin : coins) {
            for (int i = coin; i <= x; i++) {
                dp[i] += dp[i - coin];
                dp[i] %= MOD;
            }
        }

        return dp[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(countWays(n, x, coins));
        scanner.close();
    }
}
