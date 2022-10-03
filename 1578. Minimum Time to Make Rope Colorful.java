class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int count = 0;
        for (int i = 1; i < n; i++){
            if (colors.charAt(i-1) == colors.charAt(i)){
                if (neededTime[i-1] >= neededTime[i]){
                    count += neededTime[i];
                    neededTime[i] = neededTime[i-1];
                }
                else{
                    count += neededTime[i-1];
                    neededTime[i-1] = neededTime[i];
                } 
            }
            
        }
        return count;
    }
}
