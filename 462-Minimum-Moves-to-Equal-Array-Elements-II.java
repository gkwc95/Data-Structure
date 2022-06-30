class Solution {
    public int minMoves2(int[] nums) {
        int operations = 0, median = quickSelect(nums, 0, nums.length-1, nums.length/2);
        for (int num : nums){
            operations += Math.abs(median-num);
        }
        return operations;
    }
    
    public int quickSelect(int[] nums, int left, int right, int k){
        if (left == right) return nums[left];
        
        int pivot = new Random().nextInt(right-left+1)+left;
        pivot = partition(nums, left, right, pivot);
        
        if (pivot == k) return nums[pivot];
        if (pivot < k) return quickSelect(nums, pivot+1, right, k);
        else return quickSelect(nums, left, pivot-1, k);
    }
    
    public int partition(int[] nums, int left, int right, int pivot){
        int j = left-1;
        swap(nums, pivot, right);
        for (int i = left; i < right; i++){
            if (nums[i] <= nums[right]){
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j+1, right);
        return j+1;
    }
    
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
