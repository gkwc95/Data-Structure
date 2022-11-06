class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            return String.valueOf(tmp);
        }
        else{
            String res = s;
            for (int i = 0; i < s.length(); i++){
                s = s.substring(1) + s.substring(0,1);
                if (res.compareTo(s) > 0){
                    res = s;
                }
            }
            return res;
        }
    }
}
