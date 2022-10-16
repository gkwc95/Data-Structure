class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[n+1][d+1];
        
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= d; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++){
            int max = jobDifficulty[i-1];
            for (int j = i-1; j >= 0; j--){
                for (int day = 1; day <= d; day++){
                    if (dp[j][day-1] != Integer.MAX_VALUE){
                        dp[i][day] = Math.min(dp[i][day], dp[j][day-1]+max);
                    }
                }
                if (j-1>=0){
                    max = Math.max(max, jobDifficulty[j-1]);
                }
            }
        }
        return dp[n][d] == Integer.MAX_VALUE? -1 : dp[n][d];
        
    }
}
