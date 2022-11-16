public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right-left)/2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if(res == 1) left = mid + 1;
            else if(res == -1) right = mid - 1;
        }
        return -1;
    }
}
