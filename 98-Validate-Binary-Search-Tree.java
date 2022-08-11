class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }
    
    public boolean traverse(TreeNode root, Integer min, Integer max){
        if (root == null) return true;
        if (min != null && root.val <= min) return false; 
        if (max != null && root.val >= max) return false;
        return traverse(root.left, min, root.val) && traverse(root.right, root.val, max);
    }
}
