class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                if (tmp.left != null){
                    q.add(tmp.left);
                }
                if (tmp.right != null){
                    q.add(tmp.right);
                }
                list.add(tmp.val);
            }
            res.add(list);
        }
        return res;
    }
}
