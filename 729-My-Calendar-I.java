class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        Integer ceil = map.ceilingKey(start);
        if (floor != null && map.get(floor) > start || ceil != null && ceil < end)
            return false;
        map.put(start, end);
        return true;
    }
}
