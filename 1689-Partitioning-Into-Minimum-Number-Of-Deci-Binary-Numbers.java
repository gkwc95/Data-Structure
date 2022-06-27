class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()){
            if (c == '9') return 9;
            max = Math.max(max, c-'0');
        }
        return max;
    }
}
