class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int step = 0;
        q.add(start);
        set.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if (curr.equals(end)) return step;
                for (char c : new char[]{'A','C','G','T'}){
                    for (int i = 0; i < curr.length(); i++){
                        String newString = curr.substring(0, i) + c + curr.substring(i+1);
                        if (!set.contains(newString) && Arrays.asList(bank).contains(newString)){
                            q.add(newString);
                            set.add(newString);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
