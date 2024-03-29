class Solution {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i = 0; i < s.length(); i++){
            if (i > 0 && map.getOrDefault(s.charAt(i), 0) > map.getOrDefault(s.charAt(i-1), 0)){
                res += (map.getOrDefault(s.charAt(i), 0) - 2 * map.getOrDefault(s.charAt(i-1), 0));
            }
            else{
                res += map.getOrDefault(s.charAt(i), 0);               
            }
        }
        return res;
    }
}
