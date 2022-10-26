class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            total += nums[i];
            int r = total%k;
            if (!map.containsKey(r)){
                map.put(r, i);
            }
            else if (i-map.get(r)>1) return true;
        }
        return false;
    }
}
