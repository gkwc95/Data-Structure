class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Long, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            dp.add(i, new HashMap<>());
        }
        int res = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < i; j++){
                long diff = (long)nums[i] - (long)nums[j];
                int dpi = dp.get(i).getOrDefault(diff, 0);
                dpi += 1 + dp.get(j).getOrDefault(diff, 0);
                dp.get(i).put(diff, dpi);
                res +=  dp.get(j).getOrDefault(diff, 0);
            }
        }
        return res;
    }
}
