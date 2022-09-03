class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i<=9; i++){
            dfs(res, i, n-1, k);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
    
    public void dfs(List<Integer> res, int num, int n, int k){
        if (n == 0){
            res.add(num);
            return;
        }
        int prev = num % 10;
        if (prev+k <= 9){
           dfs(res, num*10+prev+k, n-1, k); 
        }
        if (k != 0 && prev-k >= 0){
            dfs(res, num*10+prev-k, n-1, k);
        }
    }
}
