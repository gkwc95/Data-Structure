class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null)
            root.left = pruneTree(root.left);
        if (root.right != null)
            root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        else
            return root;
    }
}
