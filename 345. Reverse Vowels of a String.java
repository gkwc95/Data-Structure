class Solution {
    public String reverseVowels(String s) {
        List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        int left = 0, right = s.length()-1;
        char[] c = s.toCharArray();
        while (left<right){
            while(left<right && !list.contains(c[left])){
                left++;
            }
            while(left<right && !list.contains(c[right])){
                right--;
            }
            swap(c, left++, right--);
        }
        return String.valueOf(c);
    }
    public void swap(char[] c, int left, int right){
        char tmp = c[left];
        c[left] = c[right];
        c[right] = tmp;
    }
}
