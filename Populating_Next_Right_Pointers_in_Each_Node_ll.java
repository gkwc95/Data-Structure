package leetcodequestion;

import java.util.*;

public class Populating_Next_Right_Pointers_in_Each_Node_ll {
	public Node connect(Node root) {
		/*if (root == null) return root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            Node dummy = new Node(0);
            while (size --> 0){
                dummy.next = q.remove();
                dummy = dummy.next;
                if (dummy.left != null)
                    q.add(dummy.left);
                if (dummy.right != null)
                    q.add(dummy.right);
            }
        }
        return root;*/
		
		if (root == null) return root;
        Node head = root;
        while (head != null){
            Node dummy = new Node(0);
            Node tmp = dummy;
            
            while (head != null){
                if (head.left != null){
                    tmp.next = head.left;
                    tmp = tmp.next;
                }
                if (head.right != null){
                    tmp.next = head.right;
                    tmp = tmp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}

/*
So the trick is to use two pointers with BFS.
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
