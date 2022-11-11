class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, end = nums.length-1;
        for (int right = 0; right < nums.length-1; right++){
            if (nums[right] != nums[right+1]){
                swap(nums, left++, right);
            }
        }
        if (nums[left] != nums[end]){
            swap(nums, left, end);
        }
        return ++left;
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
