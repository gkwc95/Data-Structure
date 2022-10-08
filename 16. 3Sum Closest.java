class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if (target == tmp) return tmp;
                else if(tmp < target) left++;
                else right--;
                if (Math.abs(target-res) > Math.abs(target-tmp)) res =tmp;
            }
        }
        return res;
    }
}
