class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];
        
        int [] res = new int[n/2];
        Queue<Integer> q = new LinkedList<>();
        int k = 0;
        Arrays.sort(changed);
        
        for (int i = 0; i < n; i++){
            int num = changed[i];
            if (!q.isEmpty() && q.peek() == num){
                res[k++] = num/2;
                q.poll();
            }
            else{
                q.add(num*2);
            }
        }
        return k == n/2 ? res: new int[0];
    }
}
