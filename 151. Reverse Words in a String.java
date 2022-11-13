class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] word = s.split(" ");
        StringBuilder sb =  new StringBuilder();
        for (int i = word.length-1; i >= 0; i--){
            if (word[i].length() > 0){
                sb.append(word[i]);
                if (i > 0)
                    sb.append(' ');
            }
            
        }
        return sb.toString(); 
    }
}
