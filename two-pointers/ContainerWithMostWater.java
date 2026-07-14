/**
 * Pattern : Two Pointers - max area
 * Time : O(n) | Space : O(1)
 * LeetCode 11 - Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i=0, j=height.length-1;
        while(i<j) {
            int vol = Math.min(height[i], height[j]) * (j-i);
            maxArea = Math.max(maxArea, vol);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}
