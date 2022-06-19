class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products)
            trie.insert(product);
        
        for (int i = 1; i <= searchWord.length(); i++){
            res.add(LookForThree(searchWord.substring(0, i), trie.root));
        }
        return res;
    }
    
    public List<String> LookForThree(String s, Node root){
        Node curr = root;
        List<String> list = new ArrayList<>();
        for (char c: s.toCharArray()){
            if (curr.children[c-'a'] == null){
                return list;
            }
            else{
                curr = curr.children[c-'a'];
            }
        }
        if (curr.isWord){
            list.add(s);
        }
        for (Node child : curr.children){
            if (child !=null){
                List<String> thisResult = dfs(child, new ArrayList<>());
                list.addAll(thisResult);
                if (list.size()>3)
                    return list.subList(0,3);
            }
        }
        return list;
    }
    
    private List<String> dfs (Node root, List<String> result){
        if (root.isWord){
            result.add(root.c);
                if (result.size()>=3){
                    return result;
                }
        }
        for (Node child : root.children){
            if (child != null){
                dfs(child, result);
            }
        }
        return result;
    }
}

class Node{
    Node[] children;
    boolean isWord;
    String c;
    
    public Node(){
        children = new Node[26];
        isWord = false;
        c = "";
    }
}

class Trie {
    Node root;
    public Trie(){
        root =  new Node();
        root.isWord = true;
    }
    
    public void insert(String s){
        Node curr = root;
        String currWord = "";
        for (char c : s.toCharArray()){
            if (curr.children[c-'a'] == null){
                curr.children[c-'a'] = new Node();
            }
            curr = curr.children[c-'a'];
            currWord += c;
            curr.c = currWord;
        }
        curr.isWord = true;
    }
}
