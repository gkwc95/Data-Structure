class Solution {
    int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove+1];
        for (int[][] arrs : memo){
            for (int[] arr : arrs){
                Arrays.fill(arr, -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn, memo);
    }
    
    public int helper (int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo){
        if (startRow >= m || startColumn >= n || startColumn < 0 || startRow < 0) return 1;
        if (maxMove == 0) return 0;
        if (memo[startRow][startColumn][maxMove] >= 0) return memo[startRow][startColumn][maxMove];
        
        memo[startRow][startColumn][maxMove] = ((helper(m, n, maxMove-1, startRow, startColumn-1, memo) + helper(m, n, maxMove-1, startRow-1, startColumn, memo))%M + (helper(m, n, maxMove-1, startRow+1, startColumn, memo) + helper(m, n, maxMove-1, startRow, startColumn+1, memo))%M)%M;                                        
        return memo[startRow][startColumn][maxMove];
    }
}
