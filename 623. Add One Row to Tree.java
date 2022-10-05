class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currDepth = 1;
        while (depth-1 != currDepth){
            int size = q.size();
            for (int i = 0; i <size; i++){
                TreeNode tmp = q.poll();
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            currDepth++;
        }
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            TreeNode tmpLeft = tmp.left;
            tmp.left = new TreeNode(val);
            tmp.left.left = tmpLeft;
            
            TreeNode tmpRight = tmp.right;
            tmp.right = new TreeNode(val);
            tmp.right.right = tmpRight;
            
            
        }
        return root;
    }
}
