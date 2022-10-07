class MyCalendarThree {
    private Map<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        int max = 0;
        int sum = 0;
        for (var value : map.values()){
            sum += value;
            max = Math.max(max, sum);
        }
        return max;
    }
}
