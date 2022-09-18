class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int leftMax = height[0];
        int rightMax = height[right];
        
        int res = 0;
        while (left<right){
            if (rightMax>leftMax){
                left++;
                leftMax = Math.max(height[left], leftMax);
                res += leftMax-height[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax-height[right];
            }
        }
        return res;
    }
}
