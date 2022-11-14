class Solution {
    Map<Integer, Integer> father = new HashMap<>();
    Map<Integer, List<Integer>> mapX = new HashMap<>();
    Map<Integer, List<Integer>> mapY = new HashMap<>();
    int N = 10000;
    public int removeStones(int[][] stones) {
        for (int[] stone : stones){
            int x = stone[0];
            int y = stone[1];
            int id = x*N+y;
            father.put(id, id);
            List<Integer> row = mapX.getOrDefault(x, new ArrayList<>());
            row.add(id);
            mapX.put(x, row);
            List<Integer> col = mapY.getOrDefault(y, new ArrayList<>());
            col.add(id);
            mapY.put(y, col);
        }

        for (Map.Entry<Integer, List<Integer>> entry : mapX.entrySet()){
            List<Integer> list = entry.getValue();
            int id0 = list.get(0);
            for (int i = 1; i < list.size(); i++){
                if (findFather(id0) != findFather(list.get(i))){
                    union(id0, list.get(i));
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : mapY.entrySet()){
            List<Integer> list = entry.getValue();
            int id0 = list.get(0);
            for (int i = 1; i < list.size(); i++){
                if (findFather(id0) != findFather(list.get(i))){
                    union(id0, list.get(i));
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int[] stone: stones){
            int fatherId = findFather(stone[0]*N+stone[1]);
            set.add(fatherId);
        }
        return stones.length-set.size();
    }

    public int findFather(int x){
        int id = father.get(x);
        if (id != x){
            father.put(x, findFather(id));
        }
        return father.get(x);
    }

    public void union(int x, int y){
        x = father.get(x);
        y = father.get(y);
        if (x < y){
            father.put(x, y);
        }
        else{
            father.put(y, x);
        }
    }
}
