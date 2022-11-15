class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int res =1;
        int h1 = findLeftDepth(root.left);
        int h2 = findRightDepth(root.left);
        int h3 = findLeftDepth(root.right);
        if (h1 == h2){
            res += Math.pow(2, h1)-1;
            return res + countNodes(root.right);
        }
        else{
            res += Math.pow(2, h3)-1;
            return res + countNodes(root.left);
        }
    }

    public int findLeftDepth(TreeNode root){
        int count = 0;
        while (root != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int findRightDepth(TreeNode root){
        int count = 0;
        while (root != null){
            count++;
            root = root.right;
        }
        return count;
    }
}
