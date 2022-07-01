class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        int res = 0;
        int i = 0;
        while (i < boxTypes.length && truckSize > 0){
            int min = Math.min(boxTypes[i][0] ,truckSize);
            res += min * boxTypes[i][1];
            i++;
            truckSize -= min;
        }
        return res;
    }
}
