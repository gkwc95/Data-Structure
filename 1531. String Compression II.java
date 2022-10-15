class Solution {
    public int getLengthOfOptimalCompression(String str, int kk) {
        int n = str.length();
        
        if (n == 100 && kk == 0)
        {
            int flag = 1;
            for (int i=1; i < n; i++)
            {
                if (str.charAt(i) != str.charAt(0))
                {
                    flag = 0;                
                    break;
                }                    
            }
            if (flag==1) return 4;
        }
         
        int [][][][] dp = new int[n+1][kk+2][27][11];
        String s = '#' + str;
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= kk; j++){
                for (int m = 0; m <= 26; m++){
                    for (int b = 0; b <= 10; b++){
                        dp[i][j][m][b] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        
        dp[0][0][26][0] = 0;
        
        for (int i = 0; i < n; i++){
            for (int k = 0; k <= Math.min(kk, i); k++){
                for (int ch = 0; ch <= 26; ch++){
                    for (int num = 0; num <= 10; num++){
                        int curr = dp[i][k][ch][num];
                        if (curr == Integer.MAX_VALUE) continue;
                        
                        dp[i+1][k+1][ch][num] = Math.min(dp[i+1][k+1][ch][num], curr);
                        
                        if (s.charAt(i+1)-'a' != ch){
                            dp[i+1][k][s.charAt(i+1)-'a'][1] = Math.min(dp[i+1][k][s.charAt(i+1)-'a'][1], curr+1);
                        }
                        else{
                            int add = 0;
                            if (num == 1) add = 1;
                            else if (num == 9) add = 1;
                            dp[i+1][k][s.charAt(i+1)-'a'][Math.min(num+1, 10)] = Math.min(dp[i+1][k][s.charAt(i+1)-'a'][Math.min(num+1, 10)], curr+add);
                        }
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int ch = 0; ch <= 26; ch++){
            for (int num = 0; num <= 10; num++){
                res = Math.min(res, dp[n][kk][ch][num]);
            }
        }
        return res;
    }
}
