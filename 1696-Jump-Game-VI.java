class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{nums[0], 0});
        for (int i = 1; i < n; i++){
            if (!dq.isEmpty() && i-dq.peekFirst()[1] > k){
                dq.pollFirst();
            }
            int curr = dq.peekFirst()[0] + nums[i];
            while (!dq.isEmpty() && curr > dq.peekLast()[0]){
                dq.pollLast();
            }
            dq.add(new int[]{curr, i});
        }
        return dq.pollLast()[0];
    }
}
