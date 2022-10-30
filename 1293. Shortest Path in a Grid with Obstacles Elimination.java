class Solution {
    boolean[][][] visited;
    public int shortestPath(int[][] grid, int K) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n ==1) return 0;
        
        visited = new boolean[m+1][n+1][K+1];
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 
        
        while (!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                int k = tmp[2];
                for (int[] dir: dirs){
                    int i = r + dir[0];
                    int j = c + dir[1];
                    if (i < 0 || i >= m || j < 0 || j >= n) continue;
                    if (i == m-1 && j == n-1) return step+1;
                    if (grid[i][j] == 1){
                        if (k == K || visited[i][j][k+1]) continue;
                        visited[i][j][k+1] = true;
                        q.add(new int[]{i, j, k+1});
                    }
                    else{
                        if (visited[i][j][k]) continue;
                        visited[i][j][k] = true;
                        q.add(new int[]{i, j, k});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
