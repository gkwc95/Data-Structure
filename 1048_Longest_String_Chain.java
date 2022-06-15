class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->a.length()-b.length());
        int res =0;
        Map<String, Integer> memo = new HashMap<>();
        for (String word : words){
            memo.put(word, 1);
            for (int i = 0; i < word.length(); i++){
                StringBuilder s = new StringBuilder(word);
                String tmp = s.deleteCharAt(i).toString();
                if (memo.containsKey(tmp)){
                    memo.put(word, Math.max(memo.get(tmp)+1 , memo.get(word)));
                }
            }
            res = Math.max(res , memo.get(word));
        }
        return res;
    }
}
