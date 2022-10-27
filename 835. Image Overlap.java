class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        int m = img1.length, n = img1[0].length;
        for (int i = -m+1; i < m; i++){
            for (int j = -n+1; j < n; j++){
                res = Math.max(res, overlap(img1, img2, i, j));
            }
        }
        return res;
    }
    
    public int overlap(int[][] img1, int[][] img2, int offsetRow, int offsetCol){
        int count = 0;
        for (int i = 0; i < img1.length; i++){
            for (int j = 0; j < img1[0].length; j++){
                if (i + offsetRow < 0 || i + offsetRow >= img1.length || j + offsetCol < 0 || j + offsetCol >= img2.length) {
                    continue;
                }
                else if (img1[i][j] + img2[i+offsetRow][j+offsetCol] > 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
