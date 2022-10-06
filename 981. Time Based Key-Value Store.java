class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> tmp = map.getOrDefault(key, new ArrayList<Pair<Integer, String>>());
        tmp.add(new Pair(timestamp, value));
        map.put(key, tmp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<Integer, String>> tmp = map.get(key);
        int left = 0, right = tmp.size();
        while(left < right){
            int mid = left + (right-left)/2;
            int midValue = tmp.get(mid).getKey();
            if (midValue > timestamp) {
                right = mid;
            }
            else {
               left = mid + 1 ;
            }
        }
        if (right == 0) return "";
        return tmp.get(right-1).getValue();
    }
}
