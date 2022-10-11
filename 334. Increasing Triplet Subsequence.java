class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max1 = Integer.MAX_VALUE, max2 = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= max1) max1 = num;
            else if (num <= max2) max2 = num;
            else return true;
        }
        return false;
    }
}
