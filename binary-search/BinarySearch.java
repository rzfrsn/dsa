/**
 * Pattern : Binary Search (Dichotomic search) - left/right pointers, mid comparison
 * Time : O(log n) | Space : O(1)
 * LeetCode 704 - Binary Search
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
