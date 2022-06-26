class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0, r = cardPoints.length - k;
        int total = 0;
        
        for (int i = r; i < cardPoints.length; i++){
            total += cardPoints[i];
        }
        int res = total;
        
        while (r < cardPoints.length){
            total += cardPoints[l] - cardPoints[r];
            res = Math.max(res, total);
            l++;
            r++;
        }
        return res;
    }
}
