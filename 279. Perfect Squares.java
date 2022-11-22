class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            dp[i] = n;
            for (int x = 1; x <= Math.sqrt(i); x++){
                dp[i] = Math.min(dp[i], dp[i-x*x]+1);
            }
        }
        return dp[n];
    }
}
