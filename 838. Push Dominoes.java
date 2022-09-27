class Solution {
    public String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        Queue<Pair> q = new LinkedList<>();
        int n = res.length;
        for (int i = 0; i < n; i++){
            if (res[i] != '.'){
                q.add(new Pair(i, res[i]));
            }    
        }
        
        while (!q.isEmpty()){
            Pair pair = q.poll();
            int index = pair.index;
            char fall = pair.fall;
            
            if (fall == 'L' && index > 0 && res[index-1] == '.'){
                res[index-1] = fall;
                q.add(new Pair(index-1, fall));
            }
            else if (fall == 'R' && index+1 < n && res[index+1] == '.'){
                if (index+2 < n && res[index+2] == 'L'){
                    q.poll();
                }
                else{
                    res[index+1] = fall;
                    q.add(new Pair(index+1, fall));
                }
            } 
        }
        return String.valueOf(res);
    }
}

class Pair{
    int index;
    char fall;
    public Pair(int index, char fall){
        this.index = index;
        this.fall = fall;
    }
}
