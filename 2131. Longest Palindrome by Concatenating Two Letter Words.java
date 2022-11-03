class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        int flag = 0;
        int res = 0;
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> m : map.entrySet()){
            String str1 = m.getKey();
            if (set.contains(str1)) continue;
            int a = (int)m.getValue();
            
            StringBuilder sb = new StringBuilder(str1);
            sb.reverse();
            String str2 = sb.toString();
            set.add(str2);
            if (str1.equals(str2)){
                int k = a/2; 
                res += 4*k;
                if (a % 2 == 1){
                    flag = 2;
                }
            }
            else {
                int b = map.getOrDefault(str2, 0);
                int k = Math.min(a, b);
                res += k*4;
            }
        }
        return res+flag;
    }
}
