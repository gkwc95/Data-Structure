class Tuple implements Comparable<Tuple>{
    TreeNode root;
    int row;
    int col;
    public Tuple(TreeNode root, int row, int col){
        this.root = root;
        this.row = row;
        this.col = col;
    }
    
    public int compareTo(Tuple b){
        if(col != b.col) return col - b.col;
        if(row != b.row) return row - b.row;
        return root.val - b.root.val;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Tuple tuple = q.poll();
                TreeNode node = tuple.root;
                int x = tuple.row;
                int y = tuple.col;
                
                TreeMap<Integer, PriorityQueue<Integer>> tmp = map.getOrDefault(y, new TreeMap<>());
                PriorityQueue<Integer> tmp2 = tmp.getOrDefault(x, new PriorityQueue<>());
                tmp2.add(node.val);
                tmp.put(x, tmp2);
                map.put(y, tmp);
                
                if (node.left != null){
                    q.add(new Tuple(node.left, x+1, y-1));
                }
                
                if (node.right != null){
                    q.add(new Tuple(node.right, x+1, y+1));
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> tmp : map.values()){
            List<Integer> res2 = new ArrayList<>();
            for (PriorityQueue<Integer> tmp2 : tmp.values()){
                while(!tmp2.isEmpty()){
                    res2.add(tmp2.poll());
                }
            }
            res.add(res2);
        }
        return res;
    }
}
