class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] persons = new int[n][2];
        for (int i = 0; i < n; i++){
            persons[i][0] = efficiency[i];
            persons[i][1] = speed[i];
        }
        Arrays.sort(persons, (a, b) -> b[0]-a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0;
        long res = 0;
        
        for (int i = 0; i < n; i++){
            if (pq.size()>k-1){
                speedSum -= pq.poll();
            }    
            speedSum += persons[i][1];
            res = Math.max(res, (speedSum * persons[i][0]));
            pq.add(persons[i][1]);
        }
        
        return (int) (res % 1000000007);
    }
}
