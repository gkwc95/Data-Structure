class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= m; j++){
                dp[i][j] = Integer.MIN_VALUE/2;
            }
        }
        dp[0][0] = 0;
        int res = Integer.MIN_VALUE;
        for (int len = 1; len <= m; len++){
            for (int i = 0; i <= len; i++){
                int j = len-i;
                if (i >= 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + nums[i-1]*multipliers[i+j-1]);
                if (j >= 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + nums[n-j]*multipliers[i+j-1]);
                if (len == m){
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
