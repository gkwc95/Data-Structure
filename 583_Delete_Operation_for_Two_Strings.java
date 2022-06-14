class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] dp = new int[m+1];
        for (int i = 0; i <= n; i++){
            int[] tmp = new int[m+1];
            for (int j = 0; j <= m; j++){
                if (i == 0 || j == 0)
                    tmp[j] = i+j;
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    tmp[j] = dp[j-1];
                else
                    tmp[j] = 1 + Math.min(tmp[j-1], dp[j]);
            }
            dp = tmp;
        }
        return dp[m];
    }
}
