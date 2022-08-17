class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (int i = 0;i < words.length; i++){
            String tmp = "";
            for (int j = 0; j < words[i].length(); j++){
                tmp += arr[words[i].charAt(j)-'a'];
            }
            set.add(tmp);
        }
        return set.size();
    }
}
