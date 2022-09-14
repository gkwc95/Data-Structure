class Solution {
    int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        dfs(root, new int[10]);
        return res;
    }
    
    public void dfs(TreeNode root, int[] digits){
        if (root == null){
            return;
        }
        digits[root.val]++;
        if (root.left == null && root.right == null){
            if (isPalindrome(digits)){
                res++;
            }
        }
        else{
            dfs(root.left, digits);
            dfs(root.right, digits);
        }
        digits[root.val]--;
    }
    
    public boolean isPalindrome(int[] digits){
        int odd = 0;
        for (int digit : digits){
            if (digit % 2 != 0) odd++;
        }
        if (odd > 1) return false;
        return true;
    }
}
