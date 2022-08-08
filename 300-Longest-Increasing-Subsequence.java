class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums){
            if (list.isEmpty() || num > list.get(list.size()-1)){
                list.add(num);
            }
            else{
                int position = binarySearch(list, num);
                list.set(position, num);
            }
        }
        return list.size();
    }
    
    public int binarySearch(List<Integer> list, int num){
        int left = 0, right = list.size()-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (list.get(mid) > num) right = mid-1;
            else if (list.get(mid) < num) left = mid+1;
            else return mid; 
        }
        return left;
    }
}
