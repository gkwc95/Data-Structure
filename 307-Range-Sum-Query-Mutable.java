class NumArray {
    Node root;
    int[] nums;
    public NumArray(int[] nums){
        this.nums = nums;
        int n = nums.length;
        root = new Node(0, n-1);
        init(root, 0, n-1);
    }
    
    public void update(int index, int val) {
        updateNode(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return QueryRange(root, left, right);
    }
    
    public void init(Node root, int left, int right){
        if (left == right){
            root.value = nums[left];
            return;
        }
        int mid = left + (right-left)/2;
        if (root.left == null){
            root.left = new Node(left, mid);
            root.right = new Node(mid+1, right);
        }
        init(root.left, left, mid);
        init(root.right, mid+1, right);
        root.value = root.left.value + root.right.value;
    }
    
    public void updateNode(Node root, int index, int val){
        if (index < root.lower || index > root.upper) return;
        if (root.lower == root.upper){
            root.value = val;
            return;
        }
        updateNode(root.left, index, val);
        updateNode(root.right, index, val);
        root.value = root.left.value + root.right.value;
    }
    
    public int QueryRange(Node root, int left, int right){
        if (right < root.lower || left > root.upper) return 0;
        if (left <= root.lower && right >= root.upper){
            return root.value;
        }
        return QueryRange(root.left, left, right) + QueryRange(root.right, left, right);
    }
    
}

class Node{
    int value;
    Node left;
    Node right;
    int lower;
    int upper;
    public Node(int lower, int upper){
        this.lower = lower;
        this.upper = upper;
        left = null;
        right = null;
        value = 0;
    }
}
