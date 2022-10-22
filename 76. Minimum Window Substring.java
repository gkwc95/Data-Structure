class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int minLength = s.length()+1;
        int start = 0, match = 0, startString = 0;
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for (int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0)
                    match++;
            }
            
            while(match == map.size()){
                if (end-start+1 < minLength){
                    startString = start;
                    minLength = end-start+1;
                }
                
                char delete = s.charAt(start++);
                if (map.containsKey(delete)){
                    if (map.get(delete) == 0) match--;
                    map.put(delete, map.get(delete)+1);
                }
                
            }
        }
        return minLength > s.length() ? "": s.substring(startString, startString+minLength);
    }
}
