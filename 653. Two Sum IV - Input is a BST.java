class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        int y = k - root.val;
        if (set.contains(y))return true;
        else set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
