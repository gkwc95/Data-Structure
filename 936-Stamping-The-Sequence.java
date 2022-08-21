class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int sLen = stamp.length(), tLen = target.length();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[tLen];
        int count = 0;
        
        while (count != tLen){
            boolean didChange = false;
            for (int i = 0; i <= tLen - sLen; i++){
                if (!visited[i] && canReplace(t, i, s)){
                    count = replace(t, i, sLen, count);
                    visited[i] = true;
                    didChange = true;
                    res.add(i);
                    
                    if (count == tLen) break;
                }
            }
            if (!didChange) return new int[0];
        }
        int[] result = new int[res.size()];
        int k = 0;
        for (int i = res.size()-1; i >= 0; i--)
            result[k++] = res.get(i);
        
        return result;
    }
    
    public boolean canReplace(char[] t, int index, char[] s){
        for (int i = 0; i < s.length; i++){
            if (t[i+index] != '?' && t[i+index] != s[i]){
                return false;
            }
        }
        return true;
    }
    
    public int replace(char[] t, int  index, int len, int count){
        for (int i = 0; i < len; i++){
            if (t[i+index] != '?'){
                t[i+index] = '?';
                count++;
            }
        }
        return count;
    }
}
