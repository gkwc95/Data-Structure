class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (targetSum == 0 && root == null) return false;
        else if (root == null) return false;
        else if (targetSum-root.val == 0 && root.left == null && root.right == null) return true;
        
        boolean left = hasPathSum(root.left, targetSum-root.val);
        boolean right = hasPathSum(root.right, targetSum-root.val);
        return left || right;
    }
}
