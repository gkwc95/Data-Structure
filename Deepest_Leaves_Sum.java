package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Deepest_Leaves_Sum {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null){
                    q.offer(tmp.left);
                }
                if (tmp.right != null){
                    q.offer(tmp.right);
                }
            }
        }
        return sum;
    }
}

/*
    BFS - Traverse each level of the tree and find the sum of that level.
*/

