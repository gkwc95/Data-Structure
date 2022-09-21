class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (Math.abs(nums[i])%2 == 0){
                sum += nums[i];
            }
        }
        
        
        for (int i = 0; i < n; i++){
            int index = queries[i][1];
            if (Math.abs(nums[index])%2 == 0){
                sum -= nums[index];
            }
            nums[index] += queries[i][0];
            if (Math.abs(nums[index])%2 == 0){
                sum += nums[index];
            }
            res[i] = sum;
        }
        return res;
    }
}
