/**
 * Pattern : Binary Search — pivot detection, compare mid to right anchor
 * Time : O(log n) | Space : O(1)
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return nums[right];
    }
}
