class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        Arrays.sort(count);
        int f = count[25];
        int ans = 0;
        for (int i = 25; i >= 0; i--){
            if (count[i] > f){
                if (f>0) ans += (count[i]-f);
                else ans += count[i];
            }
            f = Math.min(f-1, count[i]-1);
        }
        return ans;
    }
}
