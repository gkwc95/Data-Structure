class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while (p * n != q * m){
            m++;
            n = (q * m)/p;
        }
        if (m % 2 == 0) return 2;
        else if(n % 2 == 0) return 0;
        else return 1;
    }
}
