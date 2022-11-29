class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size()-1){
            int lastVal = list.get(list.size()-1);
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
