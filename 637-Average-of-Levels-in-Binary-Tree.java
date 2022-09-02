class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            res.add(sum/size);
        }
        return res;
    }
}
