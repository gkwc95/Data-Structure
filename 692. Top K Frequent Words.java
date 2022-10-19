class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry <String, Integer>> queue = new PriorityQueue<>((a, b)->{
            if (a.getValue() == b.getValue())
                return a.getKey().compareTo(b.getKey());
            return b.getValue()-a.getValue();
        });
        for (String word : words) map.put(word, map.getOrDefault(word, 0)+1);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            queue.add(entry);
        }
        List<String> res = new ArrayList<>();
        while(k-- > 0){
            res.add(queue.remove().getKey());
        }
        return res;
    }
}
