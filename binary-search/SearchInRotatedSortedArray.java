/**
 * Pattern : Binary Search - identify sorted half, then decide range
 * Time : O(log n) | Space : O(1)
 * LeetCode 33 - Search in Rotated Sorted Array
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]) {
                // left part
                if(target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                // right part
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
