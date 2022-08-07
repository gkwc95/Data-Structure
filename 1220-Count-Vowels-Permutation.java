class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1) return 5;
        int M = (int) (1e9 + 7);
        long[][] dp = new long[n+1][5];
        int a =0 ,e = 1, i = 2, o = 3, u = 4;
        for (int j = 0; j < 5; j++)
            dp[1][j] = 1;
        
        for (int j = 2; j <= n; j++){
            int k = j - 1;
            dp[j][a] = (dp[k][e] + dp[k][i] +dp[k][u]) % M;
            dp[j][e] = (dp[k][a] + dp[k][i]) % M;
            dp[j][i] = (dp[k][e] + dp[k][o]) % M;
            dp[j][o] = (dp[k][i]) % M;
            dp[j][u] = (dp[k][i] + dp[k][o]) % M;
        }
        
        long sum = 0;
        for (int j = 0; j < 5; j++)
            sum = (sum + dp[n][j]) % M;
        return (int) (sum % M);
    }
}
