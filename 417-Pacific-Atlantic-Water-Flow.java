class Solution {
    int[] directions = new int[]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atl = new boolean[m][n];
        boolean[][] pac = new boolean[m][n];
        
        for (int i = 0; i < n; i++){
            dfs(heights, pac, 0, i);
            dfs(heights, atl, m-1, i);
        }
        
        for (int i = 1; i < m-1; i++){
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, n-1);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pac[i][j] && atl[i][j]){
                    res.add(List.of(i, j))
                }
            }
        }
        return res;
    }
}
