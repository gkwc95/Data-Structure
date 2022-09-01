class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    
    public void helper(TreeNode root, int prevMax){
        if (root == null) return;
        if (root.val >= prevMax){
            count++;
            prevMax = root.val;
        }
        helper(root.left, prevMax);
        helper(root.right, prevMax);
    }
}
