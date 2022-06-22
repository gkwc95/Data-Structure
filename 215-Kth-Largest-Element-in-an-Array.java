class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        int kthLargest = nums.length - k;
        while(low <= high){
            int pivot = partition(nums, low, high);
            if (pivot == kthLargest){
                return nums[pivot];
            }
            else if(pivot > kthLargest){
                high = pivot - 1;
            }
            else{
                low = pivot + 1;
            }
        }
        return - 1;
    }
    
    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i+1;
    }
    
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
