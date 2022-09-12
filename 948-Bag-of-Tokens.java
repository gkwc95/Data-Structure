class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1;
        int score = 0;
        while (left <= right){
            if (power >= tokens[left]){
                power -= tokens[left++];
                score++;
            }
            else if (score != 0 && left != right) {
                power += tokens[right--];
                score--;
            }
            else break;
        }
        return score;
    }
}
