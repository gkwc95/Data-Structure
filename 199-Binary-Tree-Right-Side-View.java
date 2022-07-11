class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size =q.size();
            for (int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                if (i == size-1) res.add(tmp.val);
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
        }
        return res;
    }
}
