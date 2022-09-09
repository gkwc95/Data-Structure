class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? a[0]-b[0]: b[1]-a[1]);
        Stack<Integer> stack = new Stack<>();
        int count= 0;
        for (int[] property: properties){
            while(!stack.isEmpty() && property[1] > stack.peek()){
                    count++;
                    stack.pop();
            }
            stack.push(property[1]);
        }
        return count;
    }
}
