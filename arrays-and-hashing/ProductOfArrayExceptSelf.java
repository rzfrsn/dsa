/**
 * Pattern : Prefix / Suffix
 * Time : O(n) | Space : O(1)
 * LeetCode 238 - Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1; i < nums.length; i++) {
            res[i] = nums[i-1] * res[i-1];
        }


        int t = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            t *= nums[i+1];
            res[i] = res[i] * t;
        }

        return res;
    }
}
