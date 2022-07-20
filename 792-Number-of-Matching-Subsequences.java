class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, ArrayList<Integer>> pos = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ArrayList<Integer> tmp = pos.getOrDefault(c, new ArrayList<Integer>());
            tmp.add(i);
            pos.put(c, tmp);
        }
        
        int count = 0;
        for (String word : words){
            if (check(word, pos, s.length()-1)){
                count++;
            }
        }
        return count;
    }
    
    public boolean check(String word, Map<Character, ArrayList<Integer>> map, int n){
        int i = -1;
        for (char c : word.toCharArray()){
            if (!map.containsKey(c)) return false;
            else if (i > n) return false; 
            else {
                int j = 0;
                ArrayList<Integer> tmp = map.get(c);
                while (i > tmp.get(j)){
                    if (j >= tmp.size()-1) return false;
                    j++;
                }
                i = tmp.get(j)+1;
            }
        }
        return true;
    }
}
