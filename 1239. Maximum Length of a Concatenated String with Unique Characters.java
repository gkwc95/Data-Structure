class Solution {
    int res;
    public int maxLength(List<String> arr) {
        res = 0;
        backtracking(arr, "", 0);
        return res;
    }
    
    public void backtracking(List<String> arr, String current, int start){
        if (res < current.length()) {
            res = current.length();
        }
        for (int i = start; i < arr.size(); i++){
            if (!isValid(arr.get(i), current)) continue;
            backtracking(arr, current+arr.get(i), i+1);
        }
    }
    
    public boolean isValid(String s, String t){
        String st = s+t;
        Set<Character> set = new HashSet<>();
        for (char c : st.toCharArray()){
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
