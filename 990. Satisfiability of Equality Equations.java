class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for (int i = 0; i < 26; i++){
            parent[i] = i;
        }
        
        for (String equation : equations){
            if (equation.charAt(1) == '='){
                int a = equation.charAt(0)-'a';
                int b = equation.charAt(3)-'a';
                if (FindParent(a) != FindParent(b))
                    Union(a, b);
            }
        }
        
        for (String equation : equations){
            if (equation.charAt(1) == '!'){
                int a = equation.charAt(0)-'a';
                int b = equation.charAt(3)-'a';
                if (FindParent(a) == FindParent(b))
                    return false;
            }
        }
        return true;
    }
    
    public int FindParent(int x){
        if (parent[x] != x)
            parent[x] = FindParent(parent[x]);
        return parent[x];
    }
    
    public void Union (int x, int y){
        int a = parent[x];
        int b = parent[y];
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }
}
