class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node curr = q.poll();
                tmp.add(curr.val);
                for (Node node :curr.children){
                    if (node != null)
                        q.add(node);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
