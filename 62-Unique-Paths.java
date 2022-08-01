class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        for (int i = m-1; i >= 0; i--){
            int[] tmp = new int[n];
            for (int j = n-1; j>= 0; j--){
                if (j == n-1){
                    tmp[j] = 1;
                }
                else{
                    tmp[j] = tmp[j+1] + res[j];    
                }
            }
            res = tmp;
        }
        return res[0];
    }
}
