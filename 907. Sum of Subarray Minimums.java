class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long M = 1000000007;
        int nextSmallest[] = new int[n];
        int prevSmallest[] = new int[n];
        Arrays.fill(nextSmallest, n);
        Arrays.fill(prevSmallest, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                nextSmallest[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        for (int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                prevSmallest[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++){
            int a = prevSmallest[i];
            int b = nextSmallest[i];
            long num = arr[i]*(i-a)%M*(b-i)%M;
            res = (res+num)%M;
        }
        return (int) res;
    }
}
