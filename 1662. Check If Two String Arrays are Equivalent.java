class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        for (String word: word1){
            st1.append(word);
        }
        for (String word: word2){
            st2.append(word);
        }
        return st1.compareTo(st2) == 0;
    }
}
