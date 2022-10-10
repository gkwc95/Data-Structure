class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n < 2) return "";
        
        char[] array = palindrome.toCharArray();
        for (int i = 0; i < n/2; i++){
            if (array[i] != 'a'){
                array[i] = 'a';
                return String.valueOf(array);
            }
        }
        array[n-1] = 'b';
        return String.valueOf(array);
    }
}
