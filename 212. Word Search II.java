class Solution {
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        for (String word : words){
            insert(root, word);
        }
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if ( root.child[board[i][j]-'a'] != null){
                    dfs(res, root, board, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(List<String> res, Trie currNode, char[][] board, int row, int col){
        char c = board[row][col];
        if (c == '#' || currNode.child[c-'a'] == null) return;
        currNode = currNode.child[c-'a'];
        if (currNode.isEnd){
            res.add(currNode.word);
            currNode.isEnd = false;
            if (currNode.isEmpty()){
                return;
            }
        }
        board[row][col] = '#';
        if(row > 0) dfs(res, currNode, board, row-1, col);
        if (col > 0) dfs(res, currNode, board, row, col-1);
        if (row <board.length-1) dfs(res, currNode, board, row+1, col);
        if (col < board[0].length-1) dfs(res, currNode, board, row, col+1);
        board[row][col] = c;
    }

    public void insert(Trie root, String word){
        Trie curr = root;
        for (char c : word.toCharArray()){
            if(curr.child[c-'a'] == null){
                curr.child[c-'a'] = new Trie();
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }
}
class Trie{
    Trie[] child;
    boolean isEnd;
    String word;
    public Trie (){
        child = new Trie[26];
        isEnd = false;
        word = "";
    }

    public boolean isEmpty(){
        for (Trie ch : child){
            if (ch != null) return false;
        }
        return true;
    }
}
