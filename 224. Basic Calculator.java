class Solution {
    public int calculate(String s) {
        int sum = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9'){
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
                sum += num*sign;
                i--;
            }
            else if (c == '+'){
                sign = 1;
            }
            else if (c == '-'){
                sign = -1;
            }
            else if (c == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if (c == ')'){
                sum *= stack.pop();
                sum += stack.pop();
            }
        } 
        return sum;
    }
}
