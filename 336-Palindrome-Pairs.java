class Solution {
    public List<List<Integer>> palindromePairs(String[] words)     {
        TrieNode root = new TrieNode();
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++){
            addWord(words, i, root);    
        }
        
        for (int i = 0; i < words.length; i++){
            search(words, i, root, res);
        }
        
        return res;
    }
    
    public void addWord(String[] words, int i, TrieNode root){
        for (int j = words[i].length()-1; j >= 0; j--){
            int k = words[i].charAt(j)-'a';
            if (root.children[k] == null)
                root.children[k] =  new TrieNode();
            if (isPalindrome(words[i], 0, j)){
                root.list.add(i);
            }
            root = root.children[k];
        }
        root.list.add(i);
        root.index = i;
    }
    
    public void search(String[] words, int i, TrieNode root, List<List<Integer>> res){
        for (int j = 0; j < words[i].length(); j++){
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length()-1)){
                res.add(List.of(i, root.index));
            }
            root = root.children[words[i].charAt(j)-'a'];
            
            if (root == null) return;
        }
        for (int j : root.list){
            if (i == j) continue;
            res.add(List.of(i, j));
        }
    }
    
    public boolean isPalindrome(String word, int start, int end){
        while (start < end){
            if (word.charAt(start++) != word.charAt(end--)) return false;
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] children;
    int index;
    List<Integer> list;
    public TrieNode(){
        index = -1;
        list = new ArrayList<>();
        children = new TrieNode[26];
    }
}
