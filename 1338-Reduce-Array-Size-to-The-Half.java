class Solution {
    public int minSetSize(int[] arr) {
        int half = arr.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0, count = 0;
        for (int val : list){
            if (sum < half){
                sum += val;
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
}
