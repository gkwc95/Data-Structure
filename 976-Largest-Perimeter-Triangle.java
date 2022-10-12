class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        Arrays.sort(nums);
        for (int i = n-3; i >= 0; i--){
            if (nums[i] + nums[i+1] > nums[i+2]){
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }
}
