class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++){
            int[] tmp = new int[n];
            for (int j = i; j < m; j++){
                for (int k = 0; k < n; k++){
                    tmp[k] += matrix[j][k];
                }
                count += helper(tmp, target);
            }
        }
        return count;
    }
    
    public int helper(int[] tmp, int target){
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int presum = 0;
        for (int i = 0; i < tmp.length; i++){
            presum += tmp[i];
            count += map.getOrDefault(presum - target, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
