package com.company;

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
    TreeNode target, ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }

    public void inorder(final TreeNode original, final TreeNode cloned){
        if (original != null){
            inorder(original.left, cloned.left);
            if (original == target) ans = cloned;
            inorder(original.right, cloned.right);
        }
    }
}
/*
Inorder DFS Left, Root, Right;
 */

