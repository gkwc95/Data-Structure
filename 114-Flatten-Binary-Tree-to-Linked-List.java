class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        while (root != null){
            if (root.left != null){
                TreeNode left = root.left;
                TreeNode current = left;
                while (current.right != null) current = current.right;
                current.right = root.right;
                root.left = null;
                root.right = left;
            }
            root = root.right;
        }
    }
}
