class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1, q = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                p = q + 1;
            }
            else if (nums[i] < nums[i-1]){
                q = p + 1;
            }
        }
        return Math.max(p, q);
    }
}
