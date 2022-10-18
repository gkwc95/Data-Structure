class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = countAndSay(n-1);
        StringBuilder st = new StringBuilder();
        int left = 0, right = 0;
        while(right < res.length()){
            int count = 0;
            while (right < res.length() && res.charAt(left) == res.charAt(right)){
                right++;
                count++;
            }
            st.append(count);
            st.append(res.charAt(left));
            left = right;
        }
        return st.toString();
    }
}
