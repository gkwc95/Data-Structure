class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int bucketsForOne = (minutesToTest/minutesToDie) + 1;
        int pigs = 0;
        while (Math.pow(bucketsForOne, pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}
