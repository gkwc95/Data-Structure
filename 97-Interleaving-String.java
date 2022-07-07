class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()][s2.length()];
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1, s2, s3, s1.length()-1, s2.length()-1, s3.length()-1);
    }
    
    public boolean dfs(String s1, String s2, String s3, int l1, int l2, int l3){
        if (l1 < 0 && l2 < 0 && l3 < 0) return true;
        if (l1 >= 0 && l2 >= 0 && memo[l1][l2] == -1) return false;
        if (l1 >=0 && l2 >= 0 && s1.charAt(l1) == s3.charAt(l3) && s2.charAt(l2) == s3.charAt(l3)){
            boolean tmp =  dfs(s1, s2, s3, l1-1, l2, l3-1) || dfs(s1, s2, s3, l1, l2-1, l3-1);
            memo[l1][l2] = (tmp == true) ? 1 : -1; 
            return tmp;
        }
        else if(l1 >= 0 && s1.charAt(l1) == s3.charAt(l3)){
            return dfs(s1, s2, s3, l1-1, l2, l3-1);
        }
        else if (l2 >= 0 && s2.charAt(l2) == s3.charAt(l3)){
            return dfs(s1, s2, s3, l1, l2-1, l3-1);
        }
        return false;
    }
}
