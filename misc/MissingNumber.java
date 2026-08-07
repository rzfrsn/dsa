/**
 * Pattern : Array - missing number between 0 and n (Array.length)
 * Time : O(n) | Space : O(1)
 * 268. Missing Number
 */
class Solution {
    public int missingNumber(int[] nums) {
        // sum could be (n * (n+1) / 2) but wasn't natural for me.
        int sum = 0;
        for(int i=0; i <= nums.length; i++) {
            sum += i;
        }

        for(int i=0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
