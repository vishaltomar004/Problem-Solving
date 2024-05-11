package HomeWork.Dynamic_Programming_3;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {
      public static int minCoins(int n, int x, int[] coins) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(minCoins(n, x, coins));
        scanner.close();
    }
}
