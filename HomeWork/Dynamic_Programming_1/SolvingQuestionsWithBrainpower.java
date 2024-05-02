package HomeWork.Dynamic_Programming_1;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + getValue(i + questions[i][1] + 1, dp));
        }
        return dp[0];
    }
    
    private long getValue(int i, long[] dp) {
        if(i >= dp.length) return 0L;
        return dp[i];
    }
}
