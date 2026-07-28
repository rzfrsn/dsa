/**
 * Pattern : Binary search - treat 2D matrix as flattened 1D array
 * Time : O(log(n.m)) | Space : O(1)
 * LeetCode 74 - Search a 2D Matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if(midValue == target) return true;
            else if(midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
