class Solution {
    int n;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        int left = 0, right = 0;
        for (int i = 0; i< prices.length; i++){
            right = Math.max(right, prices[i]);
        }
        
        while(left < right){
            int fee = left + (right-left)/2;
            if (beginTransactionWithFee(prices, fee)[1] > k){
                left = fee+1;
            }
            else{
                right = fee;   
            }
        }
        return beginTransactionWithFee(prices, left)[0] + k*left;
    }
    
    public int[] beginTransactionWithFee(int[] prices, int fee){
        int[] sold = new int[n+1];
        int[] hold = new int[n+1];
        
        hold[0] = Integer.MIN_VALUE;

        int count_sold = 0;
        int count_hold = 0;
        for (int i = 0; i < n; i++){
            if (sold[i] >= hold[i]+prices[i]){
                sold[i+1] = sold[i];
            }
            else{
                sold[i+1] = hold[i]+prices[i];
                count_sold = count_hold;
            }
            if (hold[i] >= sold[i]-prices[i]-fee){
                hold[i+1] = hold[i]; 
            }
            else{
                hold[i+1] = sold[i]-prices[i]-fee;
                count_hold = count_sold+1;
            }
        }
        return new int[]{sold[n], count_sold};
    }
}
