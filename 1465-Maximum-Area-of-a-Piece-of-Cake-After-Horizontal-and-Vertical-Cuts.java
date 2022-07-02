class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long mod = (long)1e9+7;
        int r = horizontalCuts.length;
        int c = verticalCuts.length;
        
        
        long maxH = Math.max(horizontalCuts[0], h-horizontalCuts[r-1]);
        long maxW = Math.max(verticalCuts[0], w-verticalCuts[c-1]);
        
        for (int i = 0; i < r-1; i++){
            maxH = Math.max(maxH, horizontalCuts[i+1] - horizontalCuts[i]);
        }
        
        for (int i = 0; i < c-1; i++){
            maxW = Math.max(maxW, verticalCuts[i+1] - verticalCuts[i]);
        }
        
        return (int)((maxH*maxW)%mod);
    }
}
