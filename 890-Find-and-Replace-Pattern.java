class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++){
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            boolean canReplace = true;
            for (int j = 0; j < words[0].length(); j++){
                char p = pattern.charAt(j);
                char w = words[i].charAt(j);
                if ((map1.containsKey(p) && map1.get(p) != w) || (map2.containsKey(w) && map2.get(w) != p))                 {
                    canReplace = false;
                    break;    
                }
                else{
                    map1.put(p, w);
                    map2.put(w, p);
                }
            }
            if (canReplace)
                res.add(words[i]);
        }
        
        return res;
    }
}
