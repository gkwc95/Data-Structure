class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for (int i = 0; i < courses.length; i++){
            if (time + courses[i][0] <= courses[i][1]){
                time += courses[i][0];
                pq.add(courses[i][0]);
            }
            else{
                if (!pq.isEmpty() && pq.peek() > courses[i][0]){
                    time += courses[i][0] - pq.poll();
                    pq.add(courses[i][0]);
                }
            }
        }
        return pq.size();
    }
}
