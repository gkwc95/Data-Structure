class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Map<Integer, Integer> check = new HashMap<>();
        for (int num : nums){
            if (map.get(num) == 0) continue;
            if (check.getOrDefault(num, 0) > 0){
                map.put(num, map.get(num)-1);
                check.put(num, check.get(num)-1);
                check.put(num+1, check.getOrDefault(num+1, 0)+1);
            }
            else if (map.getOrDefault(num, 0) > 0 && map.getOrDefault(num+1, 0) > 0 && map.getOrDefault(num+2, 0) > 0){
                map.put(num, map.get(num)-1);
                map.put(num+1, map.get(num+1)-1);
                map.put(num+2, map.get(num+2)-1);
                check.put(num+3, check.getOrDefault(num+3, 0)+1);
            }
            else return false;
        }
        return true;
    }
}
