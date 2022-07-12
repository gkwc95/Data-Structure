class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        } 
        if (sum == 0 || sum % 4 != 0) return false;
        int length = sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[]{0, 0, 0, 0};
        return backtrack(0, length, matchsticks, sides);
    }
    
    public boolean backtrack(int index, int side, int[] matchsticks, int[] sides){
        if (index == matchsticks.length) return true;
        int curr = matchsticks[index];
        for (int i = 0; i < 4; i++){
            if (i > 0 && sides[i] == sides[i-1]) {
                continue;
            }
            if (sides[i] + curr <= side) {
                sides[i] += curr;
                if (backtrack(index+1, side, matchsticks, sides)) {
                    return true;
                }
                sides[i] -= curr;
            }
        }
        return false;
    }
    public void reverse(int[] arr){
        int left = 0, right = arr.length-1;
        while (left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
