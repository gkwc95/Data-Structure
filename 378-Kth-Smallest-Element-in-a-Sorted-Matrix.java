class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        while (left < right){
            int mid = left + (right-left)/2;
            int count = countSmallerOrEqual(mid, matrix);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    
    public int countSmallerOrEqual(int mid, int[][] matrix){
        int n = matrix.length;
        int i = n-1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n){
            if (matrix[i][j] <= mid){
                count += (i + 1);
                j++;
            }
            else{
                i--;
            }
        }
        return count;
    } 
}
